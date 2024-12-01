package com.kipcollo.notifications.payment;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentConfirmation{
    private String paymentRefernce;
    private PaymentMethod paymentMethod;
    private BigDecimal amount;
    private String firstName;
    private String lastName;
    private String email;

} 