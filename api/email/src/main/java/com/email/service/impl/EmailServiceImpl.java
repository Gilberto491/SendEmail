package com.email.service.impl;

import com.email.dto.EmailDtoRequest;
import com.email.service.EmailService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Email;

@Service
@AllArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender emailSender;

    @Email
    private final String emailFrom = "webanonymity0@gmail.com";

    @Override
    public ResponseEntity<?> sendEmail(EmailDtoRequest dto) {

        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom(emailFrom);
            simpleMailMessage.setTo(dto.getEmailTo());
            simpleMailMessage.setSubject(dto.getSubject());
            simpleMailMessage.setText(dto.getText());
            emailSender.send(simpleMailMessage);
            return ResponseEntity.ok().build();
        } catch (MailException e) {
            System.out.println(e.getCause() + e.getMessage());
            return ResponseEntity.status(HttpStatusCode.valueOf(500)).build();
        }
    }
}
