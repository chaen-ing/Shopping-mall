package project.shoppingmall.application;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.shoppingmall.domain.dto.AddProductRequest;
import project.shoppingmall.domain.dto.UpdateProductRequest;
import project.shoppingmall.domain.entity.Product;
import project.shoppingmall.repository.ProductRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional
    public Product save(AddProductRequest request){
        return productRepository.save(request.toEntity());
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Product findById(Long id){
        return productRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("not found : " + id));
    }

    // 포함된 문자열 검색
    public List<Product> findByNameContaining(String name){
        return productRepository.findByNameContaining(name);
    }

    public void delete(Long id){
        productRepository.deleteById(id);
    }

    @Transactional
    public Product update(Long id, UpdateProductRequest request){
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found : " + id));

        product.update(request.getName(), request.getPrice(), request.getAmount(), request.getDescription());

        return product;
    }




}
