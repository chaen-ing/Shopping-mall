package project.shoppingmall.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name="users")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private String user_id;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String name;
    @Column
    private String phone_number;
    @Column
    private String address;
    @OneToOne
    @JoinColumn(name="cart_id")
    private Cart cart;

    @Builder
    public User(String password, String name) {
        this.password = password;
        this.name = name;
    }
}
