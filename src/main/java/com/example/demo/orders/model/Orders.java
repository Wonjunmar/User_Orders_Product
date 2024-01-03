package com.example.demo.orders.model;

import com.example.demo.ordersproduct.model.OrdersProduct;
import com.example.demo.product.model.Product;
import com.example.demo.user.model.User;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "User_id")
    User user;

    @OneToMany(mappedBy = "orders")
    private List<OrdersProduct> ordersProducts = new ArrayList<>();

    private String impUid;

}
