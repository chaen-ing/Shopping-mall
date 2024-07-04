package project.shoppingmall.application;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.shoppingmall.domain.dto.*;
import project.shoppingmall.domain.entity.*;
import project.shoppingmall.repository.*;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class OrderService {
    private final UserRepository userRepository;
    private final CartItemRepository cartItemRepository;
    private final ProductRepository productRepository;
    private final OrderItemRepository orderItemRepository;

    @Transactional
    public Order createOrder(CreateOrderRequest request, String userEmail){
        // 인증정보 바탕으로 사용자 찾기
        User user = userRepository.findByEmail(userEmail).get();

        Order order = request.toEntity(user);

        List<CartItemViewResponse> cartItems = cartItemRepository.findByUser(user.getId());

        long totalPrice = 0L;
        // 장바구니 아이템 -> 주문 아이템
        for(CartItemViewResponse cartItemViewResponse : cartItems){
            Product product = productRepository.findById(cartItemViewResponse.getProductId()).get();

            OrderItem orderItem = OrderItem.builder()
                    .order(order)
                    .product(product)
                    .amount(cartItemViewResponse.getAmount())
                    .build();

            orderItemRepository.save(orderItem);

            totalPrice += product.getPrice() * orderItem.getAmount();
        }
        order.setTotal_price(totalPrice);

        cartItemRepository.deleteAllByUser(user.getId());
        return order;
    }
}
