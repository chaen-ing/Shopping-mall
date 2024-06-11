package project.shoppingmall.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import project.shoppingmall.domain.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
