package com.example.demo.ordersproduct.controller;

import com.example.demo.ordersproduct.service.OrdersProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ordersproduct")
public class OrdersProductController {
    OrdersProductService orderService;

    public OrdersProductController(OrdersProductService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public ResponseEntity create(Integer ordersId, Integer productId) {
        orderService.create(ordersId,productId);

        return ResponseEntity.ok().body("생성");
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete")
    public ResponseEntity delete(Integer id) {
        orderService.delete(id);
        return ResponseEntity.ok().body("삭제");
                
    }
}
