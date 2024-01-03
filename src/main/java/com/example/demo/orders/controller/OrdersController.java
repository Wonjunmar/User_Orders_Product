package com.example.demo.orders.controller;

import com.example.demo.orders.service.OrdersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrdersController {
    OrdersService orderService;

    public OrdersController(OrdersService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public ResponseEntity create(Integer memberIdx, Integer productIdx) {

//        orderService.create(memberIdx,productIdx);

        return ResponseEntity.ok().body("생성");
    }













//    @RequestMapping(method = RequestMethod.DELETE, value = "/delete")
//    public ResponseEntity delete(Integer idx) {
//        orderService.delete(idx);
//        return ResponseEntity.ok().body("삭제");
//
//    }
}
