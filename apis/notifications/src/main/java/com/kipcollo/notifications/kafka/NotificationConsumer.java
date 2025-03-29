package com.kipcollo.notifications.kafka;

import java.time.LocalDateTime;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.kipcollo.notifications.email.EmailService;
import com.kipcollo.notifications.model.Notification;
import com.kipcollo.notifications.model.NotificationType;
import com.kipcollo.notifications.order.OrderConfirmation;
import com.kipcollo.notifications.payment.PaymentConfirmation;
import com.kipcollo.notifications.repository.NotificationRepository;

import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationConsumer {

    private final NotificationRepository repo;
    private final EmailService emailService;

    @KafkaListener(topics = "payment-topic")
    public void consumePaymentNotification(PaymentConfirmation paymentConfirmation) throws MessagingException{
        log.info(String.format("Consuming message from payment-topic Topic:: %s", paymentConfirmation));

        // save to database
        repo.save(
            Notification.builder()
            .type(NotificationType.PAYMENT_CONFIRMATION)
            .notificationTime(LocalDateTime.now())
            .paymentConfirmation(paymentConfirmation)
            .build()
        );

        // send confirmation email
        var customerName = paymentConfirmation.getFirstName() + " " + paymentConfirmation.getLastName();
        emailService.sendPaymentCornfirmationEmail(
            paymentConfirmation.getEmail(), 
            customerName,
            paymentConfirmation.getAmount(),
            paymentConfirmation.getPaymentRefernce());

    }

    @KafkaListener(topics = "order-topic")
    public void consumePaymentNotification(OrderConfirmation orderConfirmation) throws MessagingException{
         // save to database
         repo.save(
            Notification.builder()
            .type(NotificationType.ORDER_CONFIRMATION)
            .notificationTime(LocalDateTime.now())
            .orderConfirmation(orderConfirmation)
            .build()
        );

         // send confirmation email
        String customerName = orderConfirmation.getCustomer().getFirstName() + " " + orderConfirmation.getCustomer().getLastName();
        emailService.sendOrderConfirmationEmail(
            orderConfirmation.getCustomer().getEmail(), 
            customerName,
            orderConfirmation.getTotalAmount(),
            orderConfirmation.getOrderReference(),
            orderConfirmation.getProduct());
        
    }
}
