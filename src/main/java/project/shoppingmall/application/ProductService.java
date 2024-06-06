package project.shoppingmall.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.shoppingmall.Repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;


}
