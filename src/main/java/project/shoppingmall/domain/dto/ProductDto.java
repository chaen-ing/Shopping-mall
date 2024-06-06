package project.shoppingmall.domain.dto;

import jakarta.validation.constraints.NotNull;

public class ProductDto {
    private Long productId;
    @NotNull
    private String productName;
    @NotNull
    private Integer productPrice;
    @NotNull
    private Integer productIdAmount;

    public Long getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public Integer getProductPrice() {
        return productPrice;
    }

    public Integer getProductIdAmount() {
        return productIdAmount;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
