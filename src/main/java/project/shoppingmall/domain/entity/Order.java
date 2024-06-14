package project.shoppingmall.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;

@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long order_id;

    @NotNull
    private Long total_price;

    @NotNull
    private String address;

    @NotNull
    private String phone_number;

    @CreatedDate @NotNull
    private LocalDate order_date;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public Order(Long total_price, String address, String phone_number, LocalDate order_date, Status status, User user) {
        this.total_price = total_price;
        this.address = address;
        this.phone_number = phone_number;
        this.order_date = order_date;
        this.status = status;
        this.user = user;
    }
}
