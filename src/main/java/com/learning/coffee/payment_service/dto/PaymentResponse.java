package com.learning.coffee.payment_service.dto;

import java.util.UUID;

public record PaymentResponse(UUID transactionId, UUID orderId, String status) {
}
