package com.example.shoppingmall.product;

import com.example.shoppingmall.utility.Validator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@AllArgsConstructor
public class ProductController {

    ProductService productService;

    @PostMapping("/products")
    public ResponseEntity registerProduct(@RequestBody Product product) {

        if (Validator.isAlpha(product.getName()) && Validator.isNumber(product.getPrice())) {

            log.info( "/products : controller - " + product.getName());

            Product savedProduct = productService.registerProduct(product);

            try {
                log.info(savedProduct.getName());
            } catch (NullPointerException e) {
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

    // 상품 전체, 카테고리별 조회
    @GetMapping("/products")
    public ResponseEntity<List<Product>> findProducts(
            @RequestParam("limit") int limit,
            @RequestParam("currentPage") int currentPage,
            @RequestParam(value = "categoryId", required = false) Integer categoryId
    ) {
        log.info("limit = {}", limit);
        log.info("currentPage = {}", currentPage);
        log.info("categoryId = {}", categoryId);

        List<Product> products;

        // TODO : null 체크는 어디서 해야할까?
        if (categoryId == null) {
            products = productService.findProducts(limit, currentPage);
        } else {
            products = productService.findProducts(limit, currentPage, categoryId);
        }

        if (products == null) {
            return new ResponseEntity<>(products, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
