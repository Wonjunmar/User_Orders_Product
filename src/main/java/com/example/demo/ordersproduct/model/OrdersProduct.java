package com.example.demo.ordersproduct.model;

import com.example.demo.orders.model.Orders;
import com.example.demo.product.model.Product;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class OrdersProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Orders_id")
    Orders orders;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Product_id")
    private Product product;

}
