package com.example.shoppingmall.order;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class OrderRepository {
    Map<Integer, Order> orderTable = new HashMap<Integer, Order>();
    int id = 0;

    public Order save(Order order) {
        order.setId(id++);
        orderTable.put(order.getId(), order);

        return orderTable.get(order.getId());
    }

    public Order findOrder(int id) {
        return orderTable.get(id);
    }
}
