package project.shoppingmall.domain.dto;

import project.shoppingmall.domain.entity.CartItem;
import project.shoppingmall.domain.entity.User;

import java.util.List;

public class CartItemViewResponse {
    private List<CartItem> cartItems;

    public CartItemViewResponse(User user){
        this.cartItems = user.getCartItems();
    }
}
