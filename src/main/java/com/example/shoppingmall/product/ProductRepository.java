package com.example.shoppingmall.product;

import org.springframework.data.domain.Limit;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

    // TODO : Limit 적용
    List<Product> findAll();
    List<Product> findAllByCategoryId(int categoryId);
}
