package project.shoppingmall.domain.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.shoppingmall.domain.entity.Cart;
import project.shoppingmall.domain.entity.RoleType;

@Getter
@Setter
public class AddUserRequest {

    private String email;

    private String password;

    private String name;

    private String phone_number;

    private String address;

    private Cart cart;

    private RoleType roleType;
}
