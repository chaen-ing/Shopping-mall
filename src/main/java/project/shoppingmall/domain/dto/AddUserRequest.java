package project.shoppingmall.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddUserRequest {

    private String email;

    private String password;

    private String name;

    private String phone_number;

    private String address;

    private String roleType;
}
