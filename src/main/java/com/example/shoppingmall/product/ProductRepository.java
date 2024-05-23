package com.example.shoppingmall.product;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository {

    @Autowired
    EntityManager entityManager;

    Map<Integer, Product> productTable = new HashMap<Integer, Product>();
    int id = 0; // DB auto_increment

    public void save(Product product) {
        entityManager.persist(product);
    }

    public Product findProductById(int id) {
        return entityManager.find(Product.class, id);
    }

    public List<Product> findProducts(int limit, int currentPage) {
        return productTable.values().stream().toList();
    }

    public List<Product> findProducts(int limit, int currentPage, int categoryId) {
        return productTable.values().stream().filter(p -> p.getCategoryId() == categoryId).toList();
    }

    public boolean deleteProduct(int id) {
        if (productTable.containsKey(id)) {
            productTable.remove(id);
            return true;
        }
        return false;
    }

    public void deleteProducts(List<Integer> productIds) {
        for(int idx = 0; idx < productIds.size(); idx++) {
            productTable.remove(productIds.get(idx));
        }
    }
}
