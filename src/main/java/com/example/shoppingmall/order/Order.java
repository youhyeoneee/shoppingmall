package com.example.shoppingmall.order;

import com.example.shoppingmall.product.Product;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
//@RequiredArgsConstructor
public class Order {
    int id;
    Product product;
    int count;

    public Order(Product orderedProduct, int count) {
        this.product = orderedProduct;
        this.count = count;
    }
}
