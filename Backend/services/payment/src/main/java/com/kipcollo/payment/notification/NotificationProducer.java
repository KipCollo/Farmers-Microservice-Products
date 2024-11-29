package com.kipcollo.payment.notification;

import org.springframework.kafka.core.KafkaTemplate;
import static org.springframework.kafka.support.KafkaHeaders.TOPIC;

import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.kipcollo.payment.dto.PaymentNotificationRequest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationProducer {

    private final KafkaTemplate<String,PaymentNotificationRequest> kafkaTemplate;

    public void sendNotification(PaymentNotificationRequest request){
        log.info("sending notification with body <{}>",request);
        Message<PaymentNotificationRequest> message = MessageBuilder
                            .withPayload(request)
                            .setHeader(TOPIC, "payment-topic")
                            .build();
            kafkaTemplate.send(message);
    }
}
