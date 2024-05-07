package com.example.shoppingmall.product;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
public class Product {
    private String name;
    private int price;
    private String description;

}
