package project.shoppingmall.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.shoppingmall.domain.entity.CartItem;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CartItemViewResponse {
    private Long id;
    private Long amount;

    public CartItemViewResponse(CartItem cartItem) {
        this.id = cartItem.getCartItem_id();
        this.amount = cartItem.getAmount();
    }
}
