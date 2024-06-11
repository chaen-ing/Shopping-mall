package project.shoppingmall.domain.dto;

import lombok.Getter;
import project.shoppingmall.domain.entity.Product;

@Getter
public class ProductResponse {
    private Long product_id;

    private String name;

    private Long price;

    private Long amount;

    private String description;

    public ProductResponse(Product product){
        this.product_id = product.getProduct_id();
        this.name = product.getName();
        this.price = product.getPrice();
        this.amount = product.getAmount();
        this.description = product.getDescription();
    }
}
