package com.email.controller;

import com.email.dto.EmailDtoRequest;
import com.email.service.EmailService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class EmailController {


    private final EmailService service;

    @PostMapping("/sending-email")
    public ResponseEntity<?> sendingEmail(@RequestBody EmailDtoRequest emailDtoRequest) {
        try {
            return service.sendEmail(emailDtoRequest);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
}
