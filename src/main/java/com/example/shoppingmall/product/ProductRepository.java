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
        // Map -> Stream -> List
        // limit, currentPage => 상품 id 범위

        // limit 4 / currentPage 1 => 0~3
        // currentPage - 1 = 0 * limit
        // limit 4 / currentPage 2 => 4~7
        // currentPage - 1 = 1 * limit
        // limit 4 / currentPage 3 => 8~11
        // currentPage - 1 = 2 * limit
        return productTable.values().stream().toList();
    }
}
