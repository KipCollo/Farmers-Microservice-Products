package com.kipcollo.order.dto;

import java.math.BigDecimal;

import com.kipcollo.order.model.PaymentMethod;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderResponse {

    private int id;
    private String reference;
    private BigDecimal totalAmount;
    private PaymentMethod paymentMethod;
    private String customerId;

}
