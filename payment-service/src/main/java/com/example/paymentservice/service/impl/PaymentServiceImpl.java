package com.example.paymentservice.service.impl;

import com.example.paymentservice.entity.TranscationDetail;
import com.example.paymentservice.model.PaymentRequest;
import com.example.paymentservice.repository.PaymentRepository;
import com.example.paymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    PaymentRepository paymentRepository;


    @Override
    public Long doPayment(PaymentRequest paymentRequest) {

        TranscationDetail transcationDetail = TranscationDetail.builder()
                .orderId(paymentRequest.getOrderId())
                .paymentDate(Instant.now())
                .paymentStatus("SUCCESS")
                .referenceNumber(paymentRequest.getReferenceNumber())
                .amount(paymentRequest.getAmount())
                .paymentMode(paymentRequest.getPaymentMode().name())
                .build();

        transcationDetail = paymentRepository.save(transcationDetail);

        return transcationDetail.getOrderId();
    }
}
