package project.shoppingmall.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long order_id;

    @Column(nullable = false)
    private Integer total_price;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String phone_number;

    @Column(nullable = false)
    private LocalDateTime localDateTime;

    @Column(nullable = false)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
