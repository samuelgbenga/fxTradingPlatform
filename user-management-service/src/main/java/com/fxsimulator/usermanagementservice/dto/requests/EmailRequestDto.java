package com.fxsimulator.usermanagementservice.dto.requests;


public record EmailRequestDto(

        String to,

        String subject,

        String fullName,

        String extra
) {
}
