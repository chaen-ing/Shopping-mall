package project.shoppingmall.application;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.shoppingmall.domain.Product;
import project.shoppingmall.infrastructure.ListProductRepository;
import project.shoppingmall.presentation.ProductDto;

@Service
public class SimpleProductService {

    // DI
    private final ListProductRepository listProductRepository;
    private final ModelMapper modelMapper;
    @Autowired
    SimpleProductService(ListProductRepository listProductRepository,ModelMapper modelMapper){
        this.listProductRepository = listProductRepository;
        this.modelMapper = modelMapper;
    }

    public ProductDto add(ProductDto productDto){
        // 1. ProductDto를 Product로 변환
        Product product = modelMapper.map(productDto, Product.class);

        // 2. 레포지토리 호출
        Product savedProduct = listProductRepository.add(product);

        // 3. product를 ProductDto로 변환
        ProductDto savedProductDto = modelMapper.map(product, ProductDto.class);

        // 4. DTO를 반환
        return savedProductDto;
    }
}
