package com.fxsimulator.notificationservice.configuration;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class ApplicationProperties {

    @Value("${spring.mail.username}")
    private String systemEmail;
}

