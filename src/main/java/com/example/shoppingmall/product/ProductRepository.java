package com.example.shoppingmall.product;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ProductRepository {
    Map<Integer, Product> productTable = new HashMap<Integer, Product>();
    int id = 0; // DB auto_increment

    public void save(Product product) {
        product.setId(id++);
        productTable.put(product.getId(), product);

        System.out.println(
                "/proudcts : repository - " + productTable.get(product.getId()).getName()
        );
    }

    public Product findProduct(int id) {
        return productTable.get(id);
    }
}
