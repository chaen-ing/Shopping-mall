package project.shoppingmall.application;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import project.shoppingmall.domain.dto.AddUserRequest;
import project.shoppingmall.domain.entity.User;
import project.shoppingmall.repository.UserRepository;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Long save(AddUserRequest dto){
        return userRepository.save(User.builder()
                .email(dto.getEmail())
                .password(bCryptPasswordEncoder.encode(dto.getPassword()))  // 암호화
                .name(dto.getName())
                .phone_number(dto.getPhone_number())
                .address(dto.getAddress())
                .cart(dto.getCart())
                .roleType(dto.getRoleType())
                .build()).getId();

    }
}
