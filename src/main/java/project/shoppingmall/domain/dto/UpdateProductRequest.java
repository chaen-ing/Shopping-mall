package project.shoppingmall.domain.dto;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateProductRequest {
    private String name;

    private Long price;

    private Long amount;

    private String description;

}
