package project.shoppingmall.domain.dto;

import lombok.Getter;
import project.shoppingmall.domain.entity.Product;

@Getter
public class ProductListViewResponse {
    private final Long product_id;

    private final String name;

    private final Long price;

    private final Long amount;

    private final String description;

    public ProductListViewResponse(Product product) {
        this.product_id = product.getProduct_id();
        this.name = product.getName();
        this.price = product.getPrice();
        this.amount = product.getAmount();
        this.description = product.getDescription();
    }
}
