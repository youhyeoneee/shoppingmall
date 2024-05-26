package com.example.shoppingmall.order;


import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDTO {
    @Min(value = 1, message = "상품 아이디는 1 이상의 정수여야 합니다.")
    int productId;
    @Min(value = 1, message = "수량은 1 이상의 정수여야 합니다.")
    int count;
}
