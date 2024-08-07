package project.shoppingmall.domain.dto;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.shoppingmall.domain.entity.CartItem;
import project.shoppingmall.domain.entity.Product;
import project.shoppingmall.domain.entity.User;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CartItemViewResponse {

    private List<CartItem> cartItems;
    private Long cartItemId;
    private String productName;
    private Long productId;
    private Long productPrice;
    private Long amount;

    public CartItemViewResponse(Long cartItemId, String productName, Long productId, Long productPrice, Long amount) {
        this.cartItemId = cartItemId;
        this.productName = productName;
        this.productId = productId;
        this.productPrice = productPrice;
        this.amount = amount;
    }

    public CartItemViewResponse(CartItemViewResponse cartItemViewResponse) {
        this.cartItemId = cartItemViewResponse.getCartItemId();
        this.productId = cartItemViewResponse.getProductId();
        this.productName = cartItemViewResponse.getProductName();
        this.productPrice = cartItemViewResponse.getProductPrice();
        this.amount = cartItemViewResponse.getAmount();
    }

}
