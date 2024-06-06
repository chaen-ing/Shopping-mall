package project.shoppingmall.domain.product;

import org.junit.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import project.shoppingmall.Repository.ProductRepository;
import project.shoppingmall.domain.entity.Product;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductRepositoryTest {
    @Autowired
    ProductRepository productRepository;

    @AfterEach
    void cleanup(){
        productRepository.deleteAll();
    }

    @Test
    void 상품저장_불러오기(){
        // given : 주어진 조건
        Product product1 = Product.builder()
                .name("연필")
                .amount(200)
                .price(1000).build();

        productRepository.save(product1);

        // when : 검증할것
        List<Product> all = productRepository.findAll();

        // then : 검증하기
        Product product = all.get(0);
        assertThat(product.getAmount()).isEqualTo(product1.getAmount());
    }
}
