package com.fxsimulator.notificationservice.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record EmailRequestDto(
        @NotBlank(message = "field 'to' is mandatory : it can not be blank")
        @Email(message = "field 'to' must be a well formated email")
        String to,

        @NotBlank(message = "field 'subject' is mandatory : it can not be blank")
        String subject,

        @NotBlank(message = "field 'subject' is mandatory : it can not be blank")
        String fullName,

        String extra
) {
}