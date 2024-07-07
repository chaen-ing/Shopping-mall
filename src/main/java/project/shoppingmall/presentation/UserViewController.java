package project.shoppingmall.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import project.shoppingmall.application.UserService;
import project.shoppingmall.domain.dto.UserViewResponse;
import project.shoppingmall.domain.entity.User;

import java.security.Principal;

@RequiredArgsConstructor
@Controller
public class UserViewController {
    private final UserService userService;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/signup")
    public String signup(){
        return "signup";
    }


    @GetMapping("/user/info")
    public String userInfo(Model model, Principal principal){
        User user = userService.findByEmail(principal.getName());
        model.addAttribute("user",user);
        return "userInfo";
    }

    @GetMapping("/user/update")
    public String userUpdate(Model model, Principal principal){
        User user = userService.findByEmail(principal.getName());
        model.addAttribute("user",user);
        return "userUpdate";
    }


}
