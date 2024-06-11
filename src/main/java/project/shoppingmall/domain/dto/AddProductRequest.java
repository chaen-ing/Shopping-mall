package project.shoppingmall.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.shoppingmall.domain.entity.Product;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddProductRequest {
    private String name;

    private Long price;

    private Long amount;

    private String description;

    // dto -> entity
    public Product toEntity(){
        return Product.builder()
                .name(name)
                .price(price)
                .amount(amount)
                .description(description)
                .build();
    }
}
