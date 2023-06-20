package com.example.orderservice.controller;

import com.example.orderservice.model.OrderRequest;
import com.example.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vi/orders")
public class OrderController {
    @Autowired
    OrderService orderService;
    @PostMapping("/saveOrders")
    public Long saveOrderDetails(@RequestBody OrderRequest orderRequest){
        return orderService.placeOrder(orderRequest);
    }
}
