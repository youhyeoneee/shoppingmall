package com.example.shoppingmall.order;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class OrderService {
    OrderRepository orderRepository;
    public Order registerOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order findOrder(int id) {
        return orderRepository.findOrder(id);
    }
}
