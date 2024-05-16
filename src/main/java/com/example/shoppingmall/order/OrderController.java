package com.example.shoppingmall.order;

import com.example.shoppingmall.utils.Validator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@AllArgsConstructor
@RestController
public class OrderController {

    OrderService orderService;

    @PostMapping("/orders")
    public ResponseEntity registerOrder(@RequestBody Order order) {
        if (!Validator.isNumber(order.getQuantity()) || order.getProductName() == null || order.getProductName().isEmpty())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        Order savedOrder = orderService.registerOrder(order);

        if (savedOrder == null) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<Order> findOrder(@PathVariable("id") int id) {
        if (!Validator.isNumber(id)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Order resultOrder = orderService.findOrder(id);

        if (resultOrder == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(resultOrder, HttpStatus.OK);
    }

}
