package com.email.dto;

import lombok.Data;

import javax.validation.constraints.Email;

@Data
public class EmailDtoRequest {

    @Email
    private String emailTo;
    private String subject;
    private String text;
}
