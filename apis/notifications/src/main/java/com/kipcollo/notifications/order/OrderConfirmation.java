package com.kipcollo.notifications.order;

import java.math.BigDecimal;
import java.util.List;

import com.kipcollo.notifications.payment.PaymentMethod;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderConfirmation {
    private String orderReference;
    private BigDecimal totalAmount;
    private PaymentMethod paymentMethod;
    private Customer customer;
    private List<Products> product;

}
