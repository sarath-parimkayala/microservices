package com.example.paymentservice.repository;

import com.example.paymentservice.entity.TranscationDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<TranscationDetail,Long> {
}
