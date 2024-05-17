package com.example.shoppingmall.order;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Repository
public class OrderRepository {
    private Map<Integer, Order> orderTable = new HashMap<Integer, Order>();
    private int id = 0;

    public Order save(Order order) {
        log.info("order product name : " + order.getProduct().getName());
        log.info("order product count : " + order.getCount());

        order.setId(id++);
        orderTable.put(order.getId(), order);

        return orderTable.get(order.getId());
    }

    public Order findOrder(int id) {
        return orderTable.get(id);
    }
}
