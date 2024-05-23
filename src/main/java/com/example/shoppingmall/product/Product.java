package com.example.shoppingmall.product;

import com.example.shoppingmall.member.Member;
import com.example.shoppingmall.member.MemberDTO;
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
    private String name;
    private int price;
    private String description;
    private int categoryId;

    public Product(String name, int price, String description, int categoryId) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.categoryId = categoryId;
    }

    public static Product fromDtoToEntity(ProductDTO productDTO) {
        return new Product(productDTO.getName(), productDTO.getPrice(),
            productDTO.getDescription(), productDTO.getCategoryId());
    }


}
