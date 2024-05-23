package com.example.shoppingmall.product;

import com.example.shoppingmall.utils.ApiUtils;
import com.example.shoppingmall.utils.Validator;
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
    public ApiUtils.ApiResult registerProduct(@RequestBody Product product) {

        if (Validator.isAlpha(product.getName()) && Validator.isNumber(product.getPrice())) {

            log.info( "/products : controller - " + product.getName());

            Product savedProduct = productService.registerProduct(product);

            try {
                log.info(savedProduct.getName());
            } catch (NullPointerException e) {
                return ApiUtils.error("상품 등록 실패", HttpStatus.INTERNAL_SERVER_ERROR);
            }
            return ApiUtils.success(product); // TODO: HTTP Status Code CREATED 적용
        } else
            return ApiUtils.error("상품 등록 실패", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/products/{id}")
    public ApiUtils.ApiResult findProduct(@PathVariable("id") int id) {

        if (!Validator.isNumber(id)) {
            // TODO log INFO 레벨 id type
            log.info(id + " haha");
            log.trace("id {}", "haha");
            return ApiUtils.error("상품 조회 실패", HttpStatus.BAD_REQUEST);
        }

        Product resultProduct =  productService.findProduct(id);

        if (resultProduct == null) {
            return ApiUtils.error("상품이 존재하지 않습니다.", HttpStatus.NOT_FOUND);
        }

        return ApiUtils.success(resultProduct);
    }

    @GetMapping("/products")
    public ApiUtils.ApiResult findProducts(
            @RequestParam("limit") int limit,
            @RequestParam(value = "categoryId", required = false) Integer categoryId
    ) {
        log.info("limit = {}", limit);
        log.info("categoryId = {}", categoryId);

        List<Product> products;

        // TODO : null 체크는 어디서 해야할까?
        if (categoryId == null) {
            products = productService.findProducts(limit);
        } else {
            products = productService.findProducts(limit, categoryId);
        }

        if (products == null) {
            return ApiUtils.error("상품이 존재하지 않습니다.", HttpStatus.NOT_FOUND);
        }

        return ApiUtils.success(products);
    }
}
