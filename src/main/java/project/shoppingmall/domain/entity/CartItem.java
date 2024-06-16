package project.shoppingmall.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartItem_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="product_id")
    private Product product;

    @ColumnDefault("0")
    private Long amount;

    @Builder
    public CartItem(User user, Product product, Long amount) {
        this.user = user;
        this.product = product;
        this.amount += amount;
    }

    public CartItem addAmount(CartItem cartItem, Long amount){
        cartItem.amount += amount;
        return cartItem;
    }

}
