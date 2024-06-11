package project.shoppingmall.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String user_id;
    @NotNull
    private String password;
    @NotNull
    private String name;
    private String phone_number;
    private String address;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="cart_id")
    private Cart cart;

    @Builder
    public User(String password, String name, String phone_number, String address, Cart cart) {
        this.password = password;
        this.name = name;
        this.phone_number = phone_number;
        this.address = address;
        this.cart = cart;
    }
}
