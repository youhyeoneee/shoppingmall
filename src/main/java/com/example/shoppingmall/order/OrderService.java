package com.example.shoppingmall.order;

import com.example.shoppingmall.product.Product;
import com.example.shoppingmall.product.ProductRepository;
import com.example.shoppingmall.product.ProductService;
import lombok.AllArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class OrderService {
    OrderRepository orderRepository;
    ProductRepository productRepository;

    public Order orderProduct(OrderDTO orderDTO) {


        Product product = productRepository.findProduct(orderDTO.getProductId());
        Order order = new Order(product, orderDTO.getCount());

        return orderRepository.save(order);
    }

    public Order findOrder(int id) {
        return orderRepository.findOrder(id);
    }
}
