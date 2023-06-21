package dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;

@Getter @Setter
@RequiredArgsConstructor
public class BffDTO {

    @Email
    private String subject;
    private String emailTo;
    private String text;
}
