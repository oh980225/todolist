package toy.todolist.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import toy.todolist.auth.UserDetail;
import toy.todolist.entity.dto.UserDto;
import toy.todolist.service.UserDetailService;

@Slf4j
@Controller
public class UserController {
    private final UserDetailService userDetailService;

    @Autowired
    public UserController(UserDetailService userDetailService) {
        this.userDetailService = userDetailService;
    }

    @GetMapping("/signUp")
    public String signUpForm() {
        return "signup";
    }

    @PostMapping("/signUp")
    public String signUp(UserDto userDto) {
        userDetailService.joinUser(userDto);
        return "redirect:/login";
    }

    @GetMapping("/user")
    public String userAccess(Model model, Authentication authentication) {
        UserDetail userDetail = (UserDetail)authentication.getPrincipal();
        model.addAttribute("info", userDetail.getUsername());
        return "user_access";
    }
}
