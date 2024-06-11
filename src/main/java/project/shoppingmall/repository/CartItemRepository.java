package project.shoppingmall.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import project.shoppingmall.domain.entity.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
