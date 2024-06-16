package project.shoppingmall.domain.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name="users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String roleType;

    @Column(nullable = false)
    private String name;

    private String phone_number;

    private String address;

    @Builder
    public User(String email, String password, String name, String phone_number, String address, User user, String roleType, String auth) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.phone_number = phone_number;
        this.address = address;
        this.roleType = roleType;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(roleType));
    }

    @Override // 사용자의 이메일 반환(고유한 값)
    public String getUsername() {
        return email;
    }

    @Override // 사용자의 패스워드 반환
    public String getPassword() {
        return password;
    }

    @Override   // 계정 만료 여부
    public boolean isAccountNonExpired() {
        // 로직
        return true;    // true : 만료 X
    }

    @Override   // 계정 잠금 여부
    public boolean isAccountNonLocked() {
        // 로직
        return true;    // true : 잠금 X
    }

    @Override   // 패스워드 만료 여부
    public boolean isCredentialsNonExpired() {
        // 로직
        return true;
    }

    @Override   // 계정 사용 가능 여부
    public boolean isEnabled() {
        // 로직
        return true;
    }

}
