package project.shoppingmall.presentation;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import project.shoppingmall.domain.dto.AddProductRequest;
import project.shoppingmall.domain.dto.ProductResponse;
import project.shoppingmall.domain.dto.UpdateProductRequest;
import project.shoppingmall.domain.entity.Product;
import project.shoppingmall.repository.ProductRepository;

import java.util.List;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ProductApiControllerTest {
    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper;    // 직렬화, 역직렬화

    @Autowired
    private WebApplicationContext context;

    @Autowired
    ProductRepository productRepository;

    @BeforeEach
    public void setMockMvc(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        productRepository.deleteAll();
    }

    @DisplayName("addProduct : 상품 등록 성공")
    @Test
    public void addProduct() throws Exception{
        // given
        final String url = "/api/products";
        final String name = "연필";
        final Long price = 200L;
        final Long amount = 1000L;
        final String description = "good";
        final AddProductRequest userRequest = new AddProductRequest(name, price, amount, description);

        // 객체 JSON으로 직렬화
        final String requestBody = objectMapper.writeValueAsString(userRequest);

        // when : 설정한 내용으로 바탕으로 요청 전송
        ResultActions result = mockMvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(requestBody));

        // then
        result.andExpect(status().isCreated());

        List<Product> products = productRepository.findAll();

        assertThat(products.size()).isEqualTo(1);
        assertThat(products.get(0).getName()).isEqualTo(name);

    }

    @DisplayName("findAllProducts : 상품 목록 조회 성공")
    @Test
    public void findAllProducts() throws Exception{
        // given
        final String url = "/api/products";
        final String name = "연필";
        final Long price = 200L;
        final Long amount = 1000L;

        productRepository.save(Product.builder()
                .name(name)
                .price(price)
                .amount(amount)
                .build());


        // when
        final ResultActions result = mockMvc.perform(get(url).accept(MediaType.APPLICATION_JSON));

        // then
        result
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value(name))
                .andExpect(jsonPath("$[0].price").value(price));

    }

    @DisplayName("findProductById : 상품 아이디로 조회 성공")
    @Test
    public void findProductById() throws Exception{
        // given
        final String url = "/api/products/id/{id}";
        final String name = "연필";
        final Long price = 200L;
        final Long amount = 200L;

        Product savedProduct = productRepository.save(Product.builder()
                .name(name)
                .price(price)
                .amount(amount)
                .build());


        // when
        final ResultActions result = mockMvc.perform(get(url,savedProduct.getProduct_id()));

        // then
        result
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.product_id").value(savedProduct.getProduct_id()))
                .andExpect(jsonPath("$.name").value(name))
                .andExpect(jsonPath("$.price").value(price));

    }

    @DisplayName("findProductsByName : 이름으로 상품 리스트 조회 성공")
    @Test
    public void findProductsByName() throws Exception{
        // given
        final String url = "/api/products/name/{name}";
        final String name = "연필";
        final Long price = 200L;
        final Long amount = 200L;

        productRepository.save(Product.builder()
                .name(name)
                .price(price)
                .amount(amount)
                .build());

        productRepository.save(Product.builder()
                .name(name)
                .price(price)
                .amount(amount)
                .build());


        // when
        final ResultActions result = mockMvc.perform(get(url,name).accept(MediaType.APPLICATION_JSON));

        // then
        result
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value(name))
                .andExpect(jsonPath("$[1].name").value(name));

    }

    @DisplayName("deleteProduct : 상품 삭제 성공")
    @Test
    public void deleteProduct() throws Exception{
        // given
        final String url = "/api/products/id/{id}";
        final String name = "name";
        final Long price = 200L;
        final Long amount = 200L;

        Product savedProduct = productRepository.save(Product.builder()
                .name(name)
                .price(price)
                .amount(amount)
                .build());


        // when
        mockMvc.perform(delete(url,savedProduct.getProduct_id())).andExpect(status().isOk());

        // then
        List<Product> all = productRepository.findAll();

        assertThat(all).isEmpty();

    }

    @DisplayName("updateProduct : 상품 수정 성공")
    @Test
    public void updateProduct() throws Exception{
        // given
        final String url = "/api/products/id/{id}";
        final String name = "name";
        final Long price = 200L;
        final Long amount = 200L;
        final String description = "good";

        Product savedProduct = productRepository.save(Product.builder()
                .name(name)
                .price(price)
                .amount(amount)
                .build());

        final String newName = "newProduct";

        UpdateProductRequest request = new UpdateProductRequest(newName,price,amount,description);


        // when
        ResultActions result = mockMvc.perform(put(url, savedProduct.getProduct_id())
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(request)));

        // then
        result.andExpect(status().isOk());

        Product product = productRepository.findById(savedProduct.getProduct_id()).get();

        assertThat(product.getName()).isEqualTo(newName);


    }
}