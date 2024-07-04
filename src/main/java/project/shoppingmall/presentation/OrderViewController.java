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
public class OrderViewController {
    private final CartService cartService;

    // 주문서 작성 페이지
    @GetMapping("/user/new-order")
    public String getOrder(Model model, Principal principal){
        List<CartItemViewResponse> cartItems = cartService.findByUser(principal.getName()).stream()
                .map(CartItemViewResponse::new)
                .toList();
        model.addAttribute("cartItems",cartItems);
        model.addAttribute("isLoggedIn", principal != null);

        return "order";   // 뷰 반환
    }
}
