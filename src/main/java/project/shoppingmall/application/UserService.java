package project.shoppingmall.application;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import project.shoppingmall.domain.dto.AddUserRequest;
import project.shoppingmall.domain.dto.UpdateProductRequest;
import project.shoppingmall.domain.dto.UpdateUserRequest;
import project.shoppingmall.domain.entity.Product;
import project.shoppingmall.domain.entity.User;
import project.shoppingmall.repository.UserRepository;

import java.util.Optional;

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
                .roleType(dto.getRoleType())
                .build()).getId();

    }
    public User findByEmail(String email){
        return userRepository.findByEmail(email)
                .orElseThrow(()->new IllegalArgumentException("not found : " + email));
    }

    public void deleteUser(String email){
        userRepository.delete(findByEmail(email));
    }

    @Transactional
    public User update(UpdateUserRequest request, String email){
        User user = userRepository.findByEmail(email).get();

        user.update(user.getId(), user.getEmail(), user.getPassword(), user.getRoleType(), request.getName(),request.getPhone_number(),request.getAddress());

        return user;
    }


}
