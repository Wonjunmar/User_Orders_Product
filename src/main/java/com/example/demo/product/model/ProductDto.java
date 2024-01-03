package com.example.demo.product.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProductDto {

    String name;
    Integer price;

}
