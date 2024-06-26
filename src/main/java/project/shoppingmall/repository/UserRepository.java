package project.shoppingmall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.shoppingmall.domain.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
