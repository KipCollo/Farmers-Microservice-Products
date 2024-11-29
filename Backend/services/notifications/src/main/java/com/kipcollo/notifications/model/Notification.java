package com.kipcollo.notifications;

import java.time.LocalDateTime;

import com.kipcollo.notifications.order.OrderConfirmation;
import com.kipcollo.notifications.payment.PaymentConfirmation;
private com.kipcollo.notifications.NotificationType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Notification {

    private String id;
    private NotificationType type;
    private LocalDateTime notificationFTime;
    private OrderConfirmation OrderConfirmation;
    private PaymentConfirmation PaymentConfirmation;

}
