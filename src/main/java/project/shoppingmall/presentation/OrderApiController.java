package project.shoppingmall.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import project.shoppingmall.application.OrderService;
import project.shoppingmall.domain.dto.*;
import project.shoppingmall.domain.entity.CartItem;
import project.shoppingmall.domain.entity.Order;
import project.shoppingmall.domain.entity.Product;
import project.shoppingmall.exception.InsufficientStockException;

import java.security.Principal;

@RequiredArgsConstructor
@RestController
public class OrderApiController {
    private final OrderService orderService;

    @PostMapping("/api/order")
    public ResponseEntity<OrderResponse> createOrder(@RequestBody CreateOrderRequest request, Principal principal){

        try {
            Order savedOrder = orderService.createOrder(request, principal.getName());
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new OrderResponse(savedOrder));
        } catch (InsufficientStockException e) {
            // 예외 발생 시 처리할 내용
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new OrderResponse("재고가 부족합니다. 주문을 처리할 수 없습니다."));
        }
    }
}
