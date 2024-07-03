package project.shoppingmall.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.shoppingmall.application.CartService;
import project.shoppingmall.domain.dto.AddCartItemRequest;
import project.shoppingmall.domain.dto.CartItemResponse;
import project.shoppingmall.domain.entity.CartItem;

import java.security.Principal;

@RequiredArgsConstructor
@RestController
public class CartApiController {
    private final CartService cartService;

    // 장바구니에 물건 추가
    @PostMapping("/api/cart")
    public ResponseEntity<CartItemResponse> addCartItem(@RequestBody AddCartItemRequest request, Principal principal){
        CartItem savedCartItem = cartService.addCartItem(request, principal.getName());

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new CartItemResponse(savedCartItem));

    }

    @DeleteMapping("/api/cart/delete/{id}")
    public ResponseEntity<Void> deleteCartItem(@PathVariable("id") Long cartItemId){
        cartService.deleteCartItem(cartItemId);

        return ResponseEntity.ok().build();
    }

}
