package project.shoppingmall.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.shoppingmall.domain.Product;
import project.shoppingmall.infrastructure.ListProductRepository;

@Service
public class SimpleProductService {

    // DI
    private final ListProductRepository listProductRepository;
    @Autowired
    SimpleProductService(ListProductRepository listProductRepository){
        this.listProductRepository = listProductRepository;
    }

    public Product add(Product product){
        Product savedProduct = listProductRepository.add(product);
        return savedProduct;
    }
}
