package project.shoppingmall.infrastructure;

import org.springframework.stereotype.Repository;
import project.shoppingmall.domain.Product;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ListProductRepository {
    private List<Product> products = new CopyOnWriteArrayList<>();  // 스레드 안전성 갖는 list
    private AtomicLong sequence = new AtomicLong(1L);   // 스레드 안전성

    public Product add(Product product){
        product.setId(sequence.getAndAdd(1L));  // POST할 때 마다 1씩 증가

        products.add(product);
        return product;
    }
}
