package com.example.demo.orders.service;

import com.example.demo.orders.model.Orders;
import com.example.demo.orders.model.OrdersDto;
import com.example.demo.orders.repository.OrdersRepository;
import com.example.demo.ordersproduct.model.OrdersProduct;
import com.example.demo.ordersproduct.repository.OrdersProductRepository;
import com.example.demo.product.model.Product;
import com.example.demo.product.service.ProductService;
import com.example.demo.user.model.User;
import com.example.demo.user.model.UserDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrdersService {
    OrdersProductRepository ordersProductRepository;
    ProductService productService;
    OrdersRepository ordersRepository;

    public OrdersService(OrdersProductRepository ordersProductRepository, ProductService productService, OrdersRepository ordersRepository) {
        this.ordersProductRepository = ordersProductRepository;
        this.productService = productService;
        this.ordersRepository = ordersRepository;
    }

    public void createOrders(String impUid) {

        Orders orders = Orders.builder()
                .user(User.builder().id(1).build())
                .impUid(impUid)
                .build();
        ordersRepository.save(orders);

    }
    public void list () {
        List<Orders> ordersList = ordersRepository.findAll();
        List<OrdersDto> response = new ArrayList<>();

        for (Orders orders: ordersList) {
            OrdersDto ordersDto = OrdersDto.builder()
                    .id(orders.getId())
                    .impUid(orders.getImpUid())
                    .build();
        }
    }



//    public void delete(Integer id) {
//        ordersRepository.delete(OrdersProduct.builder()
//                .id(id).build());
//    }
}
