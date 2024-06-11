package project.shoppingmall.application;

import org.springframework.stereotype.Service;

@Service
public class SimpleProductService {
    /*

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
    public ProductSaveRequestDto add(ProductSaveRequestDto productDto){
        // 1. ProductDto를 Product로 변환
        Product product = modelMapper.map(productDto, Product.class);
        validationService.checkValid(product);  // 유효성 검사

        // 2. 레포지토리 호출
        Product savedProduct = databaseProductRepository.add(product);

        // 3. product를 ProductDto로 변환
        ProductSaveRequestDto savedProductDto = modelMapper.map(product, ProductSaveRequestDto.class);

        // 4. DTO를 반환
        return savedProductDto;
    }

    // 상품 조회 - id
    public ProductSaveRequestDto findById(Long productId){
        Product product = databaseProductRepository.findById(productId);
        ProductSaveRequestDto productDto = modelMapper.map(product, ProductSaveRequestDto.class);
        return productDto;
    }

    // 상품 조회 - 전체
    public List<ProductSaveRequestDto> findAll(){
        List<Product> products = databaseProductRepository.findAll();
        List<ProductSaveRequestDto> productDtos = products.stream()
                .map(product -> modelMapper.map(product, ProductSaveRequestDto.class))
                .toList();
        return productDtos;
    }

    // 상품 조회 - 이름
    public List<ProductSaveRequestDto> findByNameContaining(String productName){
        List<Product> products = databaseProductRepository.findByName(productName);
        List<ProductSaveRequestDto> productDtos = products.stream()
                .map(product -> modelMapper.map(product, ProductSaveRequestDto.class))
                .toList();
        return productDtos;
    }

    // 상품 수정
    public ProductSaveRequestDto update(ProductSaveRequestDto productDto){
        Product product = modelMapper.map(productDto, Product.class);
        Product updatedProduct = databaseProductRepository.update(product);
        ProductSaveRequestDto updatedProductDto = modelMapper.map(updatedProduct, ProductSaveRequestDto.class);
        return updatedProductDto;
    }

    // 상품 삭제
    public void delete(Long productId){
        databaseProductRepository.delete(productId);
    }
*/
}
