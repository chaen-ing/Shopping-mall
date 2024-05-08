package project.shoppingmall.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import project.shoppingmall.application.SimpleProductService;
import project.shoppingmall.domain.Product;

@RestController
public class ProductController {
    // 상품 추가를 위한 컨트롤러

    // DI
    private final SimpleProductService simpleProductService;
    @Autowired
    ProductController(SimpleProductService simpleProductService){
        this.simpleProductService = simpleProductService;
    }


    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public Product createProduct(@RequestBody Product product){
        // Product를 생성하고 리스트에 넣는 작업 필요
        return simpleProductService.add(product);
    }
}
