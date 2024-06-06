package project.shoppingmall.application;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.shoppingmall.domain.entity.Product;
import project.shoppingmall.Repository.DatabaseProductRepository;
import project.shoppingmall.domain.dto.ProductDto;

import java.util.List;

@Service
public class SimpleProductService {

    // DI
    private final DatabaseProductRepository databaseProductRepository;
    private final ModelMapper modelMapper;
    private final ValidationService validationService;

    @Autowired
    SimpleProductService(DatabaseProductRepository databaseProductRepository, ModelMapper modelMapper, ValidationService validationService){
        this.databaseProductRepository = databaseProductRepository;
        this.modelMapper = modelMapper;
        this.validationService = validationService;
    }

    // 상품 추가
    public ProductDto add(ProductDto productDto){
        // 1. ProductDto를 Product로 변환
        Product product = modelMapper.map(productDto, Product.class);
        validationService.checkValid(product);  // 유효성 검사

        // 2. 레포지토리 호출
        Product savedProduct = databaseProductRepository.add(product);

        // 3. product를 ProductDto로 변환
        ProductDto savedProductDto = modelMapper.map(product, ProductDto.class);

        // 4. DTO를 반환
        return savedProductDto;
    }

    // 상품 조회 - id
    public ProductDto findById(Long productId){
        Product product = databaseProductRepository.findById(productId);
        ProductDto productDto = modelMapper.map(product, ProductDto.class);
        return productDto;
    }

    // 상품 조회 - 전체
    public List<ProductDto> findAll(){
        List<Product> products = databaseProductRepository.findAll();
        List<ProductDto> productDtos = products.stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .toList();
        return productDtos;
    }

    // 상품 조회 - 이름
    public List<ProductDto> findByNameContaining(String productName){
        List<Product> products = databaseProductRepository.findByName(productName);
        List<ProductDto> productDtos = products.stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .toList();
        return productDtos;
    }

    // 상품 수정
    public ProductDto update(ProductDto productDto){
        Product product = modelMapper.map(productDto, Product.class);
        Product updatedProduct = databaseProductRepository.update(product);
        ProductDto updatedProductDto = modelMapper.map(updatedProduct, ProductDto.class);
        return updatedProductDto;
    }

    // 상품 삭제
    public void delete(Long productId){
        databaseProductRepository.delete(productId);
    }

}
