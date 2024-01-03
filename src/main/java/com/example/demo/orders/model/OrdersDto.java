package com.example.demo.orders.model;

import com.example.demo.ordersproduct.model.OrdersProduct;
import com.example.demo.product.model.Product;
import com.example.demo.user.model.User;
import com.example.demo.user.model.UserDto;
import lombok.*;

import javax.persistence.*;



@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class OrdersDto {

    Integer id;

    UserDto userDto;
    String impUid;

}
