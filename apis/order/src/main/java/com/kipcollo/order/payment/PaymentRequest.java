package com.kipcollo.order.payment;

import com.kipcollo.order.customer.CustomerResponse;
import com.kipcollo.order.model.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequest {

    private BigDecimal amount;
    private PaymentMethod paymentMethod;
    private int orderId;
    private String orderReference;
    private CustomerResponse customer;
}
