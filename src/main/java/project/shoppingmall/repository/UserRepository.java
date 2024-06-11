package project.shoppingmall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.shoppingmall.domain.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
