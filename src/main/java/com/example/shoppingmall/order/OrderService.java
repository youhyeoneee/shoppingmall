package com.example.shoppingmall.order;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class OrderService {
    OrderRepository orderRepository;

    public Orders orderProduct(Orders orders) {
        return orderRepository.save(orders);
    }

    public Orders findOrder(int id) {
        Optional<Orders> orders = orderRepository.findById(id);;

        return orders.orElse(null);
    }
}
