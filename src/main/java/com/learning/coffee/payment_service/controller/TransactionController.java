package com.learning.coffee.payment_service.controller;

import com.learning.coffee.payment_service.dto.PaymentRequest;
import com.learning.coffee.payment_service.dto.PaymentResponse;
import com.learning.coffee.payment_service.service.TransactionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/payments")
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping("/create")
    public PaymentResponse create(@Valid @RequestBody PaymentRequest request) {
        return transactionService.processTransaction(request);
    }
}
