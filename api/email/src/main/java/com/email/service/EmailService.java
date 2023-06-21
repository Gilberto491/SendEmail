package com.email.service;

import com.email.dto.EmailDtoRequest;
import org.springframework.http.ResponseEntity;

public interface EmailService {

    ResponseEntity<?> sendEmail(EmailDtoRequest dto);
}
