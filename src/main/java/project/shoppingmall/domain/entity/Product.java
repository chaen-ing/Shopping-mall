package project.shoppingmall.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Objects;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long product_id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Long price;

    @Column(nullable = false)
    private Long amount;

    private String description;

    @Builder
    public Product(String name, Long price, Long amount, String description) {
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.description = description;
    }

    public void update(String name, Long price, Long amount, String description){
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.description = description;
    }



}
