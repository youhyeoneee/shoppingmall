package com.example.shoppingmall.product;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ProductRepository {
    Map<Integer, Product> productTable = new HashMap<Integer, Product>();
    int id = 0;

    public void save(Product product) {
        productTable.put(id++, product);

        System.out.println(
                "/proudcts : repository - " + productTable.get(id - 1).getName()
        );
    }

    public void find() {

    }
}
