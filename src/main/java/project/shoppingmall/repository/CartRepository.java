package project.shoppingmall.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import project.shoppingmall.domain.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
