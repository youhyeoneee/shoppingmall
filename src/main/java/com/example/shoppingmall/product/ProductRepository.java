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

    public void save(Product product) {
        entityManager.persist(product);
    }

    public Product findProductById(int id) {
        return entityManager.find(Product.class, id);
    }

    public List<Product> findProducts(int limit) {
        String jpql = "SELECT p FROM Product AS p";

        return entityManager.createQuery(jpql, Product.class).setMaxResults(limit).getResultList();
    }

    public List<Product> findProducts(int limit, int categoryId) {
            String jpql = "SELECT p FROM Product AS p WHERE categoryId = :categoryId";

            return entityManager.createQuery(jpql, Product.class)
                    .setParameter("categoryId", categoryId).setMaxResults(limit).getResultList();
    }
}
