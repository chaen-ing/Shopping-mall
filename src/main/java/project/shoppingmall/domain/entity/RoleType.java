package project.shoppingmall.domain.entity;

public enum RoleType {
    USER("USER"),
    ADMIN("ADMIN");

    private final String authority;

    RoleType(String authority){
        this.authority = authority;
    }

    public String getAuthority() {
        return authority;
    }
}
