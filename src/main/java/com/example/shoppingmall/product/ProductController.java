package com.example.shoppingmall.product;

import com.example.shoppingmall.utility.ValidationUtil;
import com.example.shoppingmall.utility.Validator;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
public class ProductController {

    ProductService productService;

    @PostMapping("/products")
    public void registerProduct(@RequestBody Product product) {
        productService.registerProduct(product);
        System.out.println(
                "/products : controller - " + product.getName()
        );

        // * 유효성 검사 : name(영어), price(숫자), description
        // 1) 조건문
        if (Validator.isAlpha(product.getName())) {
            System.out.println("name은 잘 들어왔다.");
        }

        if (Validator.isNumber(product.getPrice())) {
            System.out.println("price는 잘 들어왔다");
        }
    }
}
