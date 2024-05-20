package com.example.shoppingmall.order;

import com.example.shoppingmall.product.Product;
import com.example.shoppingmall.product.ProductService;
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
    ProductService productService;

    @PostMapping("/orders")
    public ResponseEntity orderProduct(@RequestBody OrderDTO orderDto) {
        Product orderedProduct = productService.findProduct(orderDto.getProductId());
        // TODO : Service로 옮기기 (DTO -> Entity)
        Order requestOrder = new Order(orderedProduct, orderDto.getCount());
        orderService.orderProduct(requestOrder);

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