package com.example.demo.ordersproduct.service;

import com.example.demo.orders.model.Orders;
import com.example.demo.orders.model.OrdersDto;
import com.example.demo.ordersproduct.model.OrdersProduct;
import com.example.demo.ordersproduct.model.OrdersProductDto;
import com.example.demo.ordersproduct.repository.OrdersProductRepository;
import com.example.demo.product.model.Product;
import com.example.demo.product.model.ProductDto;
import com.example.demo.user.model.User;
import com.example.demo.user.model.UserDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrdersProductService {
    OrdersProductRepository ordersProductRepository;

    public OrdersProductService(OrdersProductRepository ordersRepository) {
        this.ordersProductRepository = ordersRepository;
    }

    public void create(Integer ordersId, Integer productId) {

        ordersProductRepository.save(OrdersProduct.builder()
                .orders(Orders.builder().id(ordersId).build())
                .product(Product.builder().id(productId).build())
                .build());
    }

    public List<OrdersProductDto> list() {
        List<OrdersProduct> result = ordersProductRepository.findAll();

        List<OrdersProductDto> ordersProductDtos = new ArrayList<>();
        for (OrdersProduct ordersProduct : result) {

            OrdersProductDto ordersProductDto = OrdersProductDto.builder()
                    .productDto(ProductDto.builder().build())
                    .ordersDto(OrdersDto.builder().build())
                    .build();
            ordersProductDtos.add(ordersProductDto);
        }
        return ordersProductDtos;
    }


    public void delete(Integer id) {
        ordersProductRepository.delete(OrdersProduct.builder()
                .id(id).build());
    }
}
