package com.example.shoppingmall.order;

import com.example.shoppingmall.product.Product;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Orders {
    @Id
    private int id;
    @OneToOne
    Product product;
    private int count;

    public Orders(Product orderedProduct, int count) {
        this.product = orderedProduct;
        this.count = count;
    }
}
