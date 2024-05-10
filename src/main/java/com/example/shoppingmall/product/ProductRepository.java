package com.example.shoppingmall.product;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository {
    Map<Integer, Product> productTable = new HashMap<Integer, Product>();
    int id = 0; // DB auto_increment

    public Product save(Product product) {
        product.setId(id++);
        productTable.put(product.getId(), product);

        System.out.println(
                "/proudcts : repository - " + productTable.get(product.getId()).getName()
        );

        return productTable.get(product.getId());
    }

    public Product findProduct(int id) {
        return productTable.get(id);
    }

    public List<Product> findProducts(int limit, int currentPage) {
        return productTable.values().stream().toList();
    }

    public List<Product> findProducts(int limit, int currentPage, int categoryId) {
        return productTable.values().stream().filter(p -> p.getCategoryId() == categoryId).toList();
    }
}
