package com.kipcollo.notifications.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.kipcollo.notifications.order.OrderConfirmation;
import com.kipcollo.notifications.payment.PaymentConfirmation;

@Service
public class NotificationConsumer {

    @KafkaListener(topics = "payment-topic")
    public void consumePaymentNotification(PaymentConfirmation paymentConfirmation){
        // save to database
        // send confirmation email

    }


    @KafkaListener(topics = "order-topic")
    public void consumePaymentNotification(OrderConfirmation orderConfirmation){
         // save to database
         // send confirmation email
        
    }
}
