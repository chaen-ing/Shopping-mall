package project.shoppingmall.application;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.shoppingmall.domain.Product;
import project.shoppingmall.infrastructure.ListProductRepository;
import project.shoppingmall.presentation.ProductDto;

import java.util.List;

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

    // 상품 추가
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

    // 상품 조회 - id
    public ProductDto findById(Long id){
        Product product = listProductRepository.findById(id);
        ProductDto productDto = modelMapper.map(product, ProductDto.class);
        return productDto;
    }

    // 상품 조회 - 전체
    public List<ProductDto> findAll(){
        List<Product> products = listProductRepository.findAll();
        List<ProductDto> productDtos = products.stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .toList();
        return productDtos;
    }

    // 상품 조회 - 이름
    public List<ProductDto> findByNameContaining(String name){
        List<Product> products = listProductRepository.findByName(name);
        List<ProductDto> productDtos = products.stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .toList();
        return productDtos;
    }

}
