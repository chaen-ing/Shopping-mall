package project.shoppingmall.domain.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.CreatedDate;
import project.shoppingmall.domain.entity.Order;
import project.shoppingmall.domain.entity.Status;
import project.shoppingmall.domain.entity.User;

import java.time.LocalDate;

public class OrderResponse {

    private Long order_id;

    private Long total_price;

    private String address;

    private String phone_number;

    private LocalDate order_date;

    private Status status;

    private User user;

    public OrderResponse(Order order) {
        this.order_id = order.getOrder_id();
        this.total_price = order.getTotal_price();
        this.address = order.getAddress();
        this.phone_number = order.getPhone_number();
        this.order_date = order.getOrder_date();
        this.status = order.getStatus();
        this.user = order.getUser();
    }
}
