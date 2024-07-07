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

import java.security.Principal;

@RequiredArgsConstructor
@RestController
public class OrderApiController {
    private final OrderService orderService;

    @PostMapping("/api/order")
    public ResponseEntity<OrderResponse> createOrder(@RequestBody CreateOrderRequest request, Principal principal){
       Order savedOrder = orderService.createOrder(request, principal.getName());

       return ResponseEntity.status(HttpStatus.CREATED)
               .body(new OrderResponse(savedOrder));
    }

//    public ResponseEntity<Product> addProduct(@RequestBody AddProductRequest addProductRequest){
//        Product savedProduct = productService.save(addProductRequest);
//
//        return ResponseEntity.status(HttpStatus.CREATED)
//                .body(savedProduct);
//    }

//    @PostMapping("/api/cart")
//    public ResponseEntity<CartItemResponse> addCartItem(@RequestBody AddCartItemRequest request, Principal principal){
//        CartItem savedCartItem = cartService.addCartItem(request, principal.getName());
//
//        return ResponseEntity.status(HttpStatus.CREATED)
//                .body(new CartItemResponse(savedCartItem));
//
//    }

}
