package project.shoppingmall.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import project.shoppingmall.domain.entity.CartItem;
import project.shoppingmall.domain.entity.Product;
import project.shoppingmall.domain.entity.User;

import java.util.List;
import java.util.Optional;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    Optional<CartItem> findByUserAndProduct (User user, Product product);

    List<CartItem> findByUser (User user);
}
