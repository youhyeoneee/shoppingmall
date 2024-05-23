package com.example.shoppingmall.product;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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

    // setter는 가능한 도메인 객체에는 만들면 안된다.
    // TODO setter는 DTO 등장하고. 지우러 오자!
}
