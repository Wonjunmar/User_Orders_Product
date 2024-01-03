package com.example.demo.product.model;

import com.example.demo.orders.model.Orders;
import com.example.demo.ordersproduct.model.OrdersProduct;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 30)
    private Integer price;

    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
    private List<OrdersProduct> ordersProducts = new ArrayList<>();

}
