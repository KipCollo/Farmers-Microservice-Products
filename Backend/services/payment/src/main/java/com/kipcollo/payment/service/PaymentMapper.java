package com.kipcollo.payment.service;

import org.springframework.stereotype.Service;

import com.kipcollo.payment.dto.PaymentRequest;
import com.kipcollo.payment.model.Payment;

@Service
public class PaymentMapper {
    public Payment toPayment(PaymentRequest request){
        return Payment.builder()
            .paymentId(request.getPaymentId())
            .paymentMethod(request.getPaymentMethod())
            .amount(request.getAmount())
            .orderId(request.getOrderId())
            .build();
    }

}
