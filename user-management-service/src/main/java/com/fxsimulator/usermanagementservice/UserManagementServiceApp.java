package com.fxsimulator.usermanagementservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Hello world!
 *
 */
@EnableFeignClients
@SpringBootApplication
@EnableAsync  // Enable Async Processing
public class UserManagementServiceApp
{
    public static void main( String[] args )
    {
        SpringApplication.run(UserManagementServiceApp.class, args);
    }
}
