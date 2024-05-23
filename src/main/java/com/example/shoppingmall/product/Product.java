package com.example.shoppingmall.product;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;

@Getter
@Entity
public class Product {
    @Id
    private int id; // PK

    @NotBlank(message = "이름을 입력해주세요.")
    @Pattern (regexp = "^[a-zA-Z0-0]*$", message = "상품 이름은 영어와 숫자만 가능합니다.")
    private String name;

    @Min(value = 0, message = "가격은 0 이상의 정수여야 합니다.")
    private int price;

    @NotBlank(message = "설명을 입력해주세요.")
    private String description;

    @Min(value = 1, message = "카테고리 아이디는 1 이상의 정수여야 합니다.")
    private int categoryId;

    // setter는 가능한 도메인 객체에는 만들면 안된다.
    // TODO setter는 DTO 등장하고. 지우러 오자!
}
