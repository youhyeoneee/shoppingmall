package com.example.shoppingmall.product;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
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
