package com.kipcollo.notifications.email;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender sender;

    @Async
    public void sendPayment(  
        String destinationEmail,
        String customerName,
        BigDecimal amount,
        String orderReference
    ) throws MessagingException{
      
        MimeMessage mimeMessage = sender.createMimeMessage();
        MimeMessageHelper messageHelper= 
            new MimeMessageHelper(mimeMessage,
                                     MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                                      StandardCharsets.UTF_8.name());    
    }

}
