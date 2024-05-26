package com.example.shoppingmall.order;

import com.example.shoppingmall.product.Product;
import com.example.shoppingmall.product.ProductService;
import com.example.shoppingmall.utils.ApiUtils;
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
    public ApiUtils.ApiResult orderProduct(@RequestBody OrderDTO orderDto) {
        Product orderedProduct = productService.findProduct(orderDto.getProductId());
        // TODO : Service로 옮기기 (DTO -> Entity)

        if (orderedProduct == null) {
            return ApiUtils.error("상품이 존재하지 않습니다.", HttpStatus.NOT_FOUND);
        }

        Orders requestOrders = new Orders(orderedProduct, orderDto.getCount());
        Orders resultOrders = orderService.orderProduct(requestOrders);

        if (resultOrders == null)
            return ApiUtils.error("주문 등록 실패", HttpStatus.INTERNAL_SERVER_ERROR);

        return ApiUtils.success(orderDto); // TODO: HTTP Status Code CREATED 적용

    }

    @GetMapping("/orders/{id}")
    public ApiUtils.ApiResult findOrder(@PathVariable("id") int id) {
        if (!Validator.isNumber(id)) {
            return ApiUtils.error("주문 조회 실패", HttpStatus.BAD_REQUEST);
        }

        Orders resultOrders = orderService.findOrder(id);

        if (resultOrders == null) {
            return ApiUtils.error("주문이 존재하지 않습니다.", HttpStatus.NOT_FOUND);
        }

        return ApiUtils.success(resultOrders);
    }

}
