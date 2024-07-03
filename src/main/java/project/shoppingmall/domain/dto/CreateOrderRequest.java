package project.shoppingmall.domain.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import project.shoppingmall.domain.entity.*;

import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CreateOrderRequest {

    private Long totalPrice;

    private String address;

    private String phone_number;

    private LocalDate order_date;

    private Status status;

    private Long userId;

    public Order toEntity(User user) {
        return Order.builder()
                .user(user)
                .address(address)
                //.total_price(totalPrice)
                .order_date(order_date)
                .phone_number(phone_number)
                .status(status)
                .build();
    }
}
