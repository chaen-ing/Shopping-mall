package project.shoppingmall.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import project.shoppingmall.domain.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
