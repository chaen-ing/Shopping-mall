package project.shoppingmall.domain.dto;

import jakarta.persistence.Column;
import project.shoppingmall.domain.entity.Product;
import project.shoppingmall.domain.entity.User;

public class UserViewResponse {
    private Long id;

    private String email;

    private String roleType;

    private String name;

    private String phone_number;

    private String address;

    public UserViewResponse(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.roleType = user.getRoleType();
        this.name = user.getName();
        this.phone_number = user.getPhone_number();
        this.address = user.getAddress();
    }
}
