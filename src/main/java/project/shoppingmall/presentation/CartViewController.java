package project.shoppingmall.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import project.shoppingmall.application.CartService;
import project.shoppingmall.domain.dto.AddCartItemResponse;

import java.security.Principal;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class CartViewController {
    private final CartService cartService;

    @GetMapping("/cart")
    public String getProducts(Model model, @AuthenticationPrincipal Principal principal){
        List<AddCartItemResponse> cartItems = cartService.findAll().stream()
                .map(AddCartItemResponse::new)
                .toList();
//        model.addAttribute("cartItems",cartItems);    // "products" 키에 리스트 저장
//
//        model.addAttribute("isLoggedIn", principal != null);    // 로그인 여부

        return "cart";   // 뷰 반환

    }
}
