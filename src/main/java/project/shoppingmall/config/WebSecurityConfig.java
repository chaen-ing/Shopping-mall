package project.shoppingmall.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import project.shoppingmall.application.UserDetailService;

import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {

    private final UserDetailService userService;

    @Bean   // h2데이터와 static 하위 리소스 스프링 시큐리티 기능 비활성화
    public WebSecurityCustomizer configure(){
        return (web) -> web.ignoring()
                //.requestMatchers(toH2Console())
                .requestMatchers(new AntPathRequestMatcher("/static/**"));
    }

    @Bean   // 특정 http 요청에 대해 웹 기반 보안 구성
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(auth-> auth
                        .requestMatchers("/login", "/signup", "/products","/user").permitAll()
//                        .requestMatchers("/cart", "/user/**").hasAuthority("USER")
                        .requestMatchers("/new-product").hasAuthority("ADMIN")
                        .anyRequest().authenticated())
                .formLogin(formLogin -> formLogin   // 폼 기반 로그인
                        .loginPage("/login")    // 경로
                        .defaultSuccessUrl("/products",true)    // 성공 시 이동
                        .permitAll())
                .logout(logout -> logout    // 로그아웃
                        .logoutSuccessUrl("/login")
                        .invalidateHttpSession(true)
                        .permitAll())
                .csrf(AbstractHttpConfigurer::disable);  // CSRF 비활성화

        return http.build();
    }

    @Bean   // 패스워드 인코더로 사용할 빈 등록
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean   // 인증 관리자 관련 설정
    public AuthenticationManager authenticationManager(HttpSecurity http, BCryptPasswordEncoder bCryptPasswordEncoder, UserDetailService userDetailService)throws Exception{
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userService);    // 사용자 정보 서비스 설정
        authProvider.setPasswordEncoder(bCryptPasswordEncoder);
        return new ProviderManager(authProvider);
    }


}
