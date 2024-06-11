package project.shoppingmall.presentation;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.shoppingmall.application.ProductService;
import project.shoppingmall.domain.dto.AddProductRequest;
import project.shoppingmall.domain.dto.ProductResponse;
import project.shoppingmall.domain.dto.UpdateProductRequest;
import project.shoppingmall.domain.entity.Product;

import java.util.List;

@RequiredArgsConstructor
@RestController // HTTP response body에 객체데이터를 JSON 형식으로 변환
public class ProductController {

    private final ProductService productService;

    @PostMapping("/api/products")
    public ResponseEntity<Product> addProduct(@RequestBody AddProductRequest addProductRequest){
        Product savedProduct = productService.save(addProductRequest);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedProduct);
    }

    @GetMapping("/api/products")
    public ResponseEntity<List<ProductResponse>> findAllProducts(){
        List<ProductResponse> products = productService.findAll()
                .stream()
                .map(ProductResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(products);
    }

    @GetMapping("/api/products/id/{id}")
    public ResponseEntity<ProductResponse> findProductById(@PathVariable Long id){
        Product product = productService.findById(id);

        return ResponseEntity.ok().body(new ProductResponse(product));
    }

    @GetMapping("/api/products/name/{name}")
    public ResponseEntity<List<ProductResponse>> findProductsByName(@PathVariable String name){
        List<ProductResponse> products = productService.findByNameContaining(name)
                .stream()
                .map(ProductResponse::new)
                .toList();


        return ResponseEntity.ok().body(products);
    }

    @DeleteMapping("/api/products/id/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
        productService.delete(id);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/api/products/id/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody UpdateProductRequest request){
        Product update = productService.update(id, request);

        return ResponseEntity.ok().body(update);
    }
}
