package com.fxsimulator.usermanagementservice.service.impl;

import com.fxsimulator.usermanagementservice.controller.NotificationRestClient;
import com.fxsimulator.usermanagementservice.dto.requests.EmailRequestDto;
import com.fxsimulator.usermanagementservice.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

   private final NotificationRestClient  notificationRestClient;

    @Override
    @Async
    public void sendRegEmail(String to, String subject, String fullName, String extra) {
        EmailRequestDto requestDto = new EmailRequestDto(to, subject, fullName, extra);
        notificationRestClient.sendRegEmail(requestDto);
    }

    @Override
    @Async
    public void sendConfirmationEmail(String to, String subject, String fullName, String extra) {
        EmailRequestDto requestDto = new EmailRequestDto(to, subject, fullName, extra);
        notificationRestClient.sendRegConfirmationEmail(requestDto);

    }
}
