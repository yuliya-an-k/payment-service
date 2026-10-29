package com.learning.coffee.payment_service.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequest {

    @NotNull(message = "Order id is required")
    private UUID orderId;

    @NotNull(message = "Payment amount is required")
    private BigDecimal totalAmount;

    @NotNull
    private Boolean accurate;
}
