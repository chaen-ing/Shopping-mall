package project.shoppingmall.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import project.shoppingmall.repository.UserRepository;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

//    @RequestMapping(value = "/signup", method = RequestMethod.POST)
//    public ProductDto createProduct(@Valid @RequestBody ProductDto productDto){
//        // Product를 생성하고 리스트에 넣는 작업 필요
//        return simpleProductService.add(productDto);
//    }
}
