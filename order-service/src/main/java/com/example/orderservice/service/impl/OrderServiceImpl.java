package com.example.orderservice.service.impl;

import com.example.orderservice.entity.Order;
import com.example.orderservice.external.ProductService;
import com.example.orderservice.model.OrderRequest;
import com.example.orderservice.repository.OrderRepository;
import com.example.orderservice.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
@Service
@Slf4j
public class OrderServiceImpl  implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProductService productService;
    @Override
    public Long placeOrder(OrderRequest orderRequest) {

        log.info("Placing order ");
        productService.reduceQuantity(orderRequest.getProductId(),orderRequest.getQuantity());
        Order order  = Order.builder()
                .amount(orderRequest.getTotalAmount())
                .quantity(orderRequest.getQuantity())
                .orderStatus("CREATED")
                .orderDate(Instant.now())
                .productId(orderRequest.getProductId())
                .build();
        order = orderRepository.save(order);
        log.info("order placed successfully with orderId : "+ order.getOrderId());
        return order.getOrderId();
    }
}
