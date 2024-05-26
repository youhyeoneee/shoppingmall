package com.example.shoppingmall.product;

import jakarta.transaction.Transactional;
import org.springframework.data.domain.Limit;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    ProductRepository productRepository;

    ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public Product registerProduct(Product product) {
        productRepository.save(product);

        return productRepository.findById(product.getId()).get();
    }

    public Product findProduct(int id) {
        return productRepository.findById(id).orElse(null);
    }

    public List<Product> findProducts(int limit) {
        return productRepository.findAll();
    }

    public List<Product> findProducts(int limit, int categoryId) {
        return productRepository.findAllByCategoryId(categoryId);
    }

}
