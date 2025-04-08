package com.fxsimulator.notificationservice.service;

import com.fxsimulator.notificationservice.payload.EmailRequestDto;

public interface EmailService {

    void sendRegistrationEmail(EmailRequestDto emailRequestDto);

    void sendTokenConfirmationEmail(EmailRequestDto emailRequestDto);
}
