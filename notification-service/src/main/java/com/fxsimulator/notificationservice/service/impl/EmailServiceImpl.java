package com.fxsimulator.notificationservice.service.impl;


import com.fxsimulator.notificationservice.configuration.ApplicationProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.thymeleaf.spring6.SpringTemplateEngine;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl {

    private final JavaMailSender javaMailSender;
    private final SpringTemplateEngine tEngine;
    private final ApplicationProperties applicationProperties;

}
