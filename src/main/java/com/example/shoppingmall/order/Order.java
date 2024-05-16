package com.example.shoppingmall.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {
    int id;
    @JsonProperty("product_name")
    String productName;
    int quantity;

}
