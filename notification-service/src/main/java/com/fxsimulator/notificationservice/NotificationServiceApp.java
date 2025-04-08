package com.fxsimulator.notificationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableAsync
public class NotificationServiceApp
{
    public static void main( String[] args )
    {
        SpringApplication.run( NotificationServiceApp.class, args );
    }
}
