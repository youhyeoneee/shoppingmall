package com.example.shoppingmall.product;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    ProductRepository productRepository;

    ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product registerProduct(Product product) {
        System.out.println(
                "/products : service - " + product.getName()
        );
        return productRepository.save(product);
    }

    public Product findProduct(int id) {
        return productRepository.findProduct(id);
    }

    public List<Product> findProducts(int limit, int currentPage) {
        return productRepository.findProducts(limit, currentPage);
    }

    public List<Product> findProducts(int limit, int currentPage, int categoryId) {
        return productRepository.findProducts(limit, currentPage, categoryId);
    }

    public boolean deleteProduct(int id) {
        return  productRepository.deleteProduct(id) && productRepository.findProduct(id) == null;
    }

    public void deleteProducts(List<Integer> productIds) {
       productRepository.deleteProducts(productIds);
    }
}
