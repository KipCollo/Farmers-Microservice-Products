package com.kipcollo.notifications.payment;

import java.math.BigDecimal;

public record PaymentConfirmation(
    String paymentRefernce,
    PaymentMethod paymentMethod,
    BigDecimal amount,
    String firstName,
    String lastName,
    String email

) {
} 