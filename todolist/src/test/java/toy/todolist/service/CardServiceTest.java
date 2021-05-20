package toy.todolist.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import toy.todolist.entity.Card;
import toy.todolist.entity.User;
import toy.todolist.entity.dto.CreatedAt;
import toy.todolist.entity.dto.SendMailDate;
import toy.todolist.repository.CardRepository;
import toy.todolist.repository.JpaCardRepository;
import toy.todolist.repository.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class CardServiceTest {
    @Autowired
    CardService cardService;
    @Autowired
    CardRepository cardRepository;
    @Autowired
    UserRepository userRepository;

    @Test
    void 카드저장() {
        LocalDate now = LocalDate.now();
        // given
        Card card = Card.builder()
                .createdAt(CreatedAt.of(now))
                .sendMailDate(SendMailDate.of(now))
                .build();
        Optional<User> user = userRepository.findById(1L);
        card.setUser(user.orElseThrow(NullPointerException::new));

        // when
        Long cardId = cardService.saveCard(card);

        // then
        Card findCard = cardService.findOneCard(cardId).orElseThrow(NullPointerException::new);
        assertThat(findCard.getId()).isEqualTo(cardId);
        assertThat(findCard.getCreatedAt()).isEqualTo(CreatedAt.of(now));
        assertThat(findCard.getSendMailDate()).isEqualTo(SendMailDate.of(now));
        assertThat(findCard.getUser().getUserId()).isEqualTo("qwer1234");
    }

    @Test
    void 모든_카드_조회() {
    }

    @Test
    void 카드삭제() {
    }
}