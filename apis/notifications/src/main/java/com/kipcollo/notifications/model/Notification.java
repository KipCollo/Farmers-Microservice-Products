package com.kipcollo.notifications.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.kipcollo.notifications.order.OrderConfirmation;
import com.kipcollo.notifications.payment.PaymentConfirmation;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Document
public class Notification {

    @Id
    private String notificationId;
    private NotificationType type;
    private LocalDateTime notificationTime;
    private OrderConfirmation orderConfirmation;
    private PaymentConfirmation paymentConfirmation;

}
