package com.learning.coffee.payment_service.service;

import com.learning.coffee.payment_service.dto.PaymentRequest;
import com.learning.coffee.payment_service.dto.PaymentResponse;
import com.learning.coffee.payment_service.entity.Transaction;
import com.learning.coffee.payment_service.entity.enumeration.TransactionStatus;
import com.learning.coffee.payment_service.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    @Transactional
    public PaymentResponse processTransaction(PaymentRequest request) {
        Optional<Transaction> existingTransaction = transactionRepository.findByOrderId(request.getOrderId());
        if (existingTransaction.isPresent()) {
            Transaction transaction = existingTransaction.get();
            return new PaymentResponse(transaction.getId(), transaction.getOrderId(),
                    transaction.getStatus().name());
        }

        Transaction transaction = create(request);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }

        if (request.getAccurate()) {
            transaction.setStatus(TransactionStatus.SUCCESSFUL);
        } else {
            transaction.setStatus(TransactionStatus.FAILED);
        }

        return new PaymentResponse(transaction.getId(), transaction.getOrderId(),
                transaction.getStatus().name());
    }

    public Transaction create(PaymentRequest request) {
        Transaction transaction = Transaction.builder()
                .orderId(request.getOrderId())
                .totalAmount(request.getTotalAmount())
                .status(TransactionStatus.PENDING)
                .build();
       return transactionRepository.save(transaction);
    }
}
