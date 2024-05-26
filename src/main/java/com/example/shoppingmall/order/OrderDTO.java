package com.example.shoppingmall.order;


import com.example.shoppingmall.product.Product;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDTO {
    @Positive(message = "상품 아이디는 양수여야 합니다.")
    int productId;

    @Positive(message = "수량은 양수여야 합니다.")
    int count;

    public Orders convertToEntity(Product product) {
        return new Orders(product, count);
    }
}
