package project.shoppingmall.application;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import project.shoppingmall.domain.dto.AddCartItemRequest;
import project.shoppingmall.domain.entity.CartItem;
import project.shoppingmall.domain.entity.Product;
import project.shoppingmall.domain.entity.User;
import project.shoppingmall.repository.CartItemRepository;
import project.shoppingmall.repository.ProductRepository;
import project.shoppingmall.repository.UserRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class CartService {

    private final ProductRepository productRepository;
    private final CartItemRepository cartItemRepository;
    private final UserRepository userRepository;

    @Transactional
    public CartItem addCart(AddCartItemRequest request, String userEmail){
        // 상품 찾기
        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(()->new IllegalArgumentException("not found : "+ request.getProductId()));

        // 인증정보 바탕으로 사용자 찾기
        User user = userRepository.findByEmail(userEmail).get();

        CartItem cartItem = cartItemRepository.findByUserAndProduct(user, product).get();

        if(cartItem == null){
            return cartItemRepository.save(request.toEntity(user, product));
        }else{  // 장바구니에 이미 존재하는 상품
           return cartItem.addAmount(cartItem, request.getAmount());
        }

    }

    public List<CartItem> findAll(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();
        User user = userRepository.findByEmail(userEmail).get();

        return cartItemRepository.findByUser(user);
    }

}
