package com.kipcollo.notifications.order;

import java.math.BigDecimal;
import java.util.List;

import com.kipcollo.notifications.payment.PaymentMethod;

public record OrderConfirmation(
    String orderReference,
    BigDecimal totalAmount,
    PaymentMethod paymentMethod,
    Customer customer,
    List<Products> product
) {
}
