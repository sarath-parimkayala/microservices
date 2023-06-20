package com.example.orderservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    @Column(name = "product_id")
    private Long productId;
    @Column(name = "quantity")
    private Long quantity;
    @Column(name = "order_date")
    private Instant orderDate;
    @Column(name = "order_status")
    private String orderStatus;
    @Column(name = "amount")
    private Long amount;

}
