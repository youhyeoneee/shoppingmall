package com.example.shoppingmall.product;

import com.example.shoppingmall.utility.Validator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@AllArgsConstructor
public class ProductController {

    ProductService productService;

    @PostMapping("/products")
    public ResponseEntity registerProduct(@RequestBody Product product) {

        if (Validator.isAlpha(product.getName()) && Validator.isNumber(product.getPrice())) {

            System.out.println(
                    "/products : controller - " + product.getName()
            );

            Product savedProduct = productService.registerProduct(product);

            try {
                System.out.println(savedProduct.getName());
            } catch (NullPointerException e) {
                System.out.println(e.toString());
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> findProduct(@PathVariable("id") int id) {
        // 1. Product 반환 필드 : id가 없어요
        // 2. id 숫자만 들어온 거 맞는지 유효성 검사

//        Logger logger = (Logger) LoggerFactory.getLogger(ProductController.class);
        if (!Validator.isNumber(id)) {
            // TODO log INFO 레벨 id type
            log.info(id + " haha");
            log.trace("id {}", "haha");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Product resultProduct =  productService.findProduct(id);

        if (resultProduct == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(resultProduct, HttpStatus.OK);
    }
}
