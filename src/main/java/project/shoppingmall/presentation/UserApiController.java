package project.shoppingmall.presentation;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.shoppingmall.application.UserService;
import project.shoppingmall.domain.dto.*;
import project.shoppingmall.domain.entity.Product;
import project.shoppingmall.domain.entity.User;
import project.shoppingmall.repository.UserRepository;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class UserApiController {
    private final UserService userService;

    @PostMapping("/user")
    public String signup(AddUserRequest request){
        userService.save(request);  // 회원 가입 메서드
        return "redirect:/login";   // 회원가입 후 로그인 페이지로
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response){
        new SecurityContextLogoutHandler().logout(request, response,
                SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/products";
    }

    @DeleteMapping("/api/user/delete")
    public ResponseEntity<Void> deleteUser(Principal principal){
        userService.deleteUser(principal.getName());

        return ResponseEntity.ok().build();
    }

    @PutMapping("/api/user/info")
    public ResponseEntity<User> updateUser(@RequestBody UpdateUserRequest request, Principal principal){
        User user = userService.update(request, principal.getName());

        return ResponseEntity.ok().body(user);
    }

}
