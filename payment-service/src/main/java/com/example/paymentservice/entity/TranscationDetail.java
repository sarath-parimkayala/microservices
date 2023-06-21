package com.example.paymentservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.time.Instant;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "payments")
public class TranscationDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "order_id")
    private Long orderId;
    @Column(name = "payment_mode")
    private String paymentMode;
    @Column(name = "reference_number")
    private String referenceNumber;
    @Column(name = "payment_date")
    private Instant paymentDate;

    @Column(name = "payment_status")
    private String paymentStatus;
    private Long amount;

    @Repository
    public static interface paymentRepository extends JpaRepository<TranscationDetail,Long> {
    }
}
