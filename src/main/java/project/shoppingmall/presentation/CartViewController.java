package project.shoppingmall.presentation;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import project.shoppingmall.application.CartService;
import project.shoppingmall.domain.dto.CartItemViewResponse;

import java.security.Principal;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class CartViewController {
    private final CartService cartService;

    @GetMapping("/user/cart")
    public String getCart(Model model,Principal principal){
        Logger logger = LoggerFactory.getLogger(CartViewController.class);

        if (principal == null) {
            logger.warn("Principal is null");
            return "redirect:/login";  // 로그인 페이지로 리다이렉트
        } else {
            logger.info("Principal name: " + principal.getName());
        }

        List<CartItemViewResponse> cartItems = cartService.findByUser(principal.getName()).stream()
                .map(CartItemViewResponse::new)
                .toList();
        model.addAttribute("cartItems",cartItems);

        model.addAttribute("isLoggedIn", principal != null);

        return "cart";   // 뷰 반환
    }


}
