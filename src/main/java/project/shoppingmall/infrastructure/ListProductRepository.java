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

    public Product findById(Long id){
        return products.stream()
                .filter(product -> product.sameId(id))
                .findFirst()
                .orElseThrow();

    }

    public List<Product> findAll(){
        return products;
    }

    public List<Product> findByName(String name){
        return products.stream()
                .filter(product -> product.containsName(name))
                .toList();
    }

    public Product update(Product product){
        Integer indexToModify = products.indexOf(product);
        // 매개변수로 받은 인스턴스와 동일한 인스턴스의 인덱스 반환
        // 이때 판단 기준 equals 메서드이므로 오버라이딩

        products.set(indexToModify, product);   // product를 통째로 변경
        return product;
    }

    public void delete(Long id){
        Product product = this.findById(id);    // 조회에서 사용한 위의 findById 재사용
        products.remove(product);
    }
}
