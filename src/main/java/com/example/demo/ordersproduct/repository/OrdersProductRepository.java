package com.example.demo.ordersproduct.repository;

import com.example.demo.ordersproduct.model.OrdersProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersProductRepository extends JpaRepository<OrdersProduct, Integer> {

}
