package com.fxsimulator.notificationservice.service.impl;


import com.fxsimulator.notificationservice.configuration.ApplicationProperties;
import com.fxsimulator.notificationservice.payload.EmailRequestDto;
import com.fxsimulator.notificationservice.service.EmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.springframework.mail.javamail.MimeMessageHelper.MULTIPART_MODE_MIXED;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender javaMailSender;
    private final SpringTemplateEngine tEngine;
    private final ApplicationProperties applicationProperties;

    private static final String REGISTRATION_TEMPLATE = "registration.html";
    private static final String REG_CONFIRMATION_TEMPLATE = "reg_confirmation.html";


    @Async
    @Override
    public void sendRegistrationEmail(EmailRequestDto dto) {
        Map<String, Object> properties = new HashMap<>();
        properties.put("fullName", dto.fullName());
        properties.put("confirmationLink", dto.extra());
        sendMail(dto.to(), dto.subject(), properties, REG_CONFIRMATION_TEMPLATE);
    }


    @Async
    @Override
    public void sendTokenConfirmationEmail(EmailRequestDto dto) {
        Map<String, Object> properties = new HashMap<>();
        properties.put("fullName", dto.fullName());
        properties.put("loginLink", dto.extra());
        sendMail(dto.to(), dto.subject(), properties, REGISTRATION_TEMPLATE);
    }



    private void sendMail(String to, String subject, Map<String, Object> properties, String templatePath)  {
        try{
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, MULTIPART_MODE_MIXED, UTF_8.name());

            Context context = new Context();
            context.setVariables(properties);

            helper.setFrom(applicationProperties.getSystemEmail());
            helper.setTo(to);
            helper.setSubject(subject);

            String template = tEngine.process(templatePath, context);
            helper.setText(template, true);
            javaMailSender.send(mimeMessage);

        }catch (MessagingException e) {
            log.warn("Failed to send notification");
            log.error(e.getMessage());
            log.error(e.getLocalizedMessage());
        }
    }





}
