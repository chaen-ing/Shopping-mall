package project.shoppingmall.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import project.shoppingmall.application.ProductService;
import project.shoppingmall.domain.dto.ProductListViewResponse;
import project.shoppingmall.domain.dto.ProductViewResponse;
import project.shoppingmall.domain.entity.Product;

import java.security.Principal;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class ProductViewController {
    private final ProductService productService;

    @GetMapping("/products")
    public String getProducts(Model model, @AuthenticationPrincipal Principal principal){
        List<ProductListViewResponse> products = productService.findAll().stream()
                .map(ProductListViewResponse::new)
                .toList();
        model.addAttribute("products",products);    // "products" 키에 리스트 저장

        model.addAttribute("isLoggedIn", principal != null);    // 로그인 여부

        return "productList";   // 뷰 반환
    }

    @GetMapping("/products/id/{id}")
    public String getProduct(@PathVariable Long id, Model model){
        Product product = productService.findById(id);
        model.addAttribute("product", new ProductViewResponse(product));

        return "product";
    }

    @GetMapping("/new-product")
    public String newProduct(@RequestParam(required = false) Long id, Model model) { // id가 있으면 매핑
        if (id == null) {   // 새로 등록
            model.addAttribute("product", new ProductViewResponse());
        }else{
            Product product = productService.findById(id);
            model.addAttribute("product",new ProductViewResponse(product));
        }

        return "newProduct";
    }
}
