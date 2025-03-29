package com.kipcollo.payment.service;

import org.springframework.stereotype.Service;

import com.kipcollo.payment.dto.PaymentNotificationRequest;
import com.kipcollo.payment.dto.PaymentRequest;
import com.kipcollo.payment.notification.NotificationProducer;
import com.kipcollo.payment.repository.PaymentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository repo;
    private final PaymentMapper mapper;
    private final NotificationProducer notificationProducer;

    public int createPayment(PaymentRequest request) {
        var payment= repo.save(mapper.toPayment(request));
        notificationProducer.sendNotification(
            new PaymentNotificationRequest(
                request.getOrderReference(),
                request.getAmount(),
                request.getPaymentMethod(),
                request.getCustomer().getFirstName(),
                request.getCustomer().getLastName(),
                request.getCustomer().getEmail()
               
            )
        );  
        
        return payment.getPaymentId();
    }

}
