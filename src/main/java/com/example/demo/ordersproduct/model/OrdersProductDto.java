package com.example.demo.ordersproduct.model;

import com.example.demo.orders.model.OrdersDto;
import com.example.demo.product.model.ProductDto;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class OrdersProductDto {

    ProductDto productDto;
    OrdersDto ordersDto;
}
