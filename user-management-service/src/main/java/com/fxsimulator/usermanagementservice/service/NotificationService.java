package com.fxsimulator.usermanagementservice.service;

public interface NotificationService {

    void sendRegEmail(String to, String subject, String fullName, String extra);

    void sendConfirmationEmail(String to, String subject, String fullName, String extra);
}
