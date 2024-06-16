package project.shoppingmall.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
public class SecurityController {
    @GetMapping("/user")
    @ResponseBody
    public String currentUserName(Principal principal){
        return principal.getName();
    }
}
