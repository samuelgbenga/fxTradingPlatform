package com.fxsimulator.usermanagementservice.controller;


import com.fxsimulator.usermanagementservice.dto.requests.EmailRequestDto;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "NOTIFICATION-SERVICE")
public interface NotificationRestClient {

    @PostMapping("/notifications/send-reg-email")
    void sendRegEmail(@RequestBody EmailRequestDto request);

    @PostMapping("/notifications/send-reg-confirmation-email")
    void sendRegConfirmationEmail(@RequestBody EmailRequestDto dto);
}
