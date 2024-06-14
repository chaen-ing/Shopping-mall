package project.shoppingmall.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import project.shoppingmall.domain.entity.Product;

@NoArgsConstructor
@Getter
public class ProductViewResponse {
    private Long product_id;

    private String name;

    private Long price;

    private Long amount;

    private String description;

    public ProductViewResponse(Product product) {
        this.product_id = product.getProduct_id();
        this.name = product.getName();
        this.price = product.getPrice();
        this.amount = product.getAmount();
        this.description = product.getDescription();
    }
}
