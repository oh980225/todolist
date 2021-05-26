package toy.todolist.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import toy.todolist.auth.UserDetail;

@Controller
@Slf4j
public class MainController {
    @GetMapping("/")
    public String getMain(Model model, Authentication authentication) {
        UserDetail userDetail = (UserDetail)authentication.getPrincipal();
        model.addAttribute("userName", userDetail.getUsername());
        return "main";
    }
}
