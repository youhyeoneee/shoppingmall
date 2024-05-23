package com.example.shoppingmall.product;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    ProductRepository productRepository;

    ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public Product registerProduct(Product product) {
        productRepository.save(product);

        return productRepository.findProductById(product.getId());
    }

    public Product findProduct(int id) {
        return productRepository.findProductById(id);
    }

    public List<Product> findProducts(int limit, int currentPage) {
        return productRepository.findProducts(limit, currentPage);
    }

    public List<Product> findProducts(int limit, int currentPage, int categoryId) {
        return productRepository.findProducts(limit, currentPage, categoryId);
    }

    public boolean deleteProduct(int id) {
        return  productRepository.deleteProduct(id) && productRepository.findProductById(id) == null;
    }

    public void deleteProducts(List<Integer> productIds) {
       productRepository.deleteProducts(productIds);
    }
}
