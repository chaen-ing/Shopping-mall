package project.shoppingmall.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.shoppingmall.domain.dto.CartItemViewResponse;
import project.shoppingmall.domain.entity.CartItem;
import project.shoppingmall.domain.entity.Product;
import project.shoppingmall.domain.entity.User;

import java.util.List;
import java.util.Optional;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    Optional<CartItem> findByUserAndProduct (User user, Product product);

    @Query("SELECT new project.shoppingmall.domain.dto.CartItemViewResponse(ci.cartItem_id, p.name, p.product_id, p.price, ci.amount) " +
            "FROM CartItem ci JOIN ci.product p WHERE ci.user.id = :userId")
    List<CartItemViewResponse> findByUser(Long userId);

}
