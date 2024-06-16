package project.shoppingmall.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.shoppingmall.domain.entity.CartItem;
import project.shoppingmall.domain.entity.Product;
import project.shoppingmall.domain.entity.User;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddCartItemRequest {

    private Long amount;
    private Long productId;
    private Long userId;

    public CartItem toEntity(User user, Product product) {
        return CartItem.builder()
                .user(user)
                .product(product)
                .amount(amount)
                .build();
    }

}
