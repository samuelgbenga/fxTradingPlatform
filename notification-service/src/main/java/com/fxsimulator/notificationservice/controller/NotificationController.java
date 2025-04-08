package com.fxsimulator.notificationservice.controller;

import com.fxsimulator.notificationservice.payload.EmailRequestDto;
import com.fxsimulator.notificationservice.service.EmailService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final EmailService emailService;

    @PostMapping("/send-reg-email")
    public void sendRegEmail(@RequestBody @Valid EmailRequestDto dto){
        emailService.sendRegistrationEmail(dto);
    }

    @PostMapping("/send-reg-confirmation-email")
    public void sendRegConfirmationEmail(@RequestBody @Valid EmailRequestDto dto){
        emailService.sendTokenConfirmationEmail(dto);
    }
}