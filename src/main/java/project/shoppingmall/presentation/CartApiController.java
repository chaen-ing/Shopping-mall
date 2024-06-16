package project.shoppingmall.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.shoppingmall.application.CartService;
import project.shoppingmall.application.ProductService;
import project.shoppingmall.application.UserService;
import project.shoppingmall.domain.dto.AddCartItemRequest;
import project.shoppingmall.domain.dto.CartItemViewResponse;
import project.shoppingmall.domain.entity.CartItem;

import java.security.Principal;

@RequiredArgsConstructor
@RestController
public class CartApiController {
    private final CartService cartService;
    private final UserService userService;
    private final ProductService productService;

    // 장바구니에 물건 추가
    @PostMapping("/api/cart")
    public ResponseEntity<CartItemViewResponse> addCartItem(@RequestBody AddCartItemRequest request, Principal principal){
        CartItem savedCartItem = cartService.addCart(request, principal.getName());

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new CartItemViewResponse(savedCartItem));

    }
}
