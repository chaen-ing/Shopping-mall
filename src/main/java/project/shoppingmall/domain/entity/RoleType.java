package project.shoppingmall.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum RoleType {
    USER("ROLE_USER"),
    ADMIN("ROLE_ADMIN");

    private String authority;

    public String getAuthority() {
        return authority;
    }
}
