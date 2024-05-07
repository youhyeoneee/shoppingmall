package com.example.shoppingmall.product;

import org.springframework.stereotype.Service;

@Service
public class ProductService {

    ProductRepository productRepository;

    ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void registerProduct(Product product) {
        productRepository.save(product);
    }
}
