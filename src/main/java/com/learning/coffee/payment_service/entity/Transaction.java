package com.learning.coffee.payment_service.entity;

import com.learning.coffee.payment_service.entity.enumeration.TransactionStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @CreationTimestamp
    private Instant createdAt;

    private UUID orderId;

    private BigDecimal totalAmount;

    @Enumerated(EnumType.STRING)
    private TransactionStatus status;

    @UpdateTimestamp
    private Instant completedAt;
}
