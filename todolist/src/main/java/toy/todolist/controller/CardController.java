package toy.todolist.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import toy.todolist.auth.UserDetail;
import toy.todolist.entity.Card;
import toy.todolist.entity.dto.CreatedAt;
import toy.todolist.service.CardService;
import toy.todolist.service.UserDetailService;

import java.time.LocalDate;

@Slf4j
@Controller
public class CardController {
    private final UserDetailService userDetailService;
    private final CardService cardService;

    public CardController(UserDetailService userDetailService, CardService cardService) {
        this.userDetailService = userDetailService;
        this.cardService = cardService;
    }

    @PostMapping("/card")
    public String saveMyCard(String date, Authentication authentication) {
        LocalDate cardDate = LocalDate.of(
                Integer.parseInt(date.substring(0, 4)),
                Integer.parseInt(date.substring(5, 7)),
                Integer.parseInt(date.substring(8, 10)));
        log.info(cardDate.toString());
        UserDetail userDetail = (UserDetail)authentication.getPrincipal();
        String userId = userDetail.getUsername();
        Card card = Card.builder()
                .createdAt(CreatedAt.of(cardDate))
                .user(userDetailService.getUserByUserId(userId))
                .build();
        cardService.saveCard(card);
        return "redirect:/";
    }
}
