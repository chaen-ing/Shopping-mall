package project.shoppingmall.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.shoppingmall.application.SimpleProductService;
import project.shoppingmall.domain.Product;

import java.util.List;

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
    public ProductDto createProduct(@RequestBody ProductDto productDto){
        // Product를 생성하고 리스트에 넣는 작업 필요
        return simpleProductService.add(productDto);
    }

    // 조회 - id
    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
    public ProductDto findProductById(@PathVariable Long id){
        return simpleProductService.findById(id);
    }

    // 조회 - 전체, 이름
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public List<ProductDto> findProduct(@RequestParam(required = false) String name)
    {
        if(null == name)
            return simpleProductService.findAll();

        return simpleProductService.findByNameContaining(name);
    }

}
