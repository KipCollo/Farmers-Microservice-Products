package com.kipcollo.payment.dto;

import java.math.BigDecimal;

import com.kipcollo.payment.model.PaymentMethod;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequest {

    private int paymentId;
    private BigDecimal amount;
    private PaymentMethod paymentMethod;
    private int orderId;
    private String orderReference;
    private Customer customer;
}
