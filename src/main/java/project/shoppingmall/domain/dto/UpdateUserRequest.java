package project.shoppingmall.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateUserRequest {
    private Long id;

    private String email;

    private String password;

    private String roleType;

    private String name;

    private String phone_number;

    private String address;
}
