package com.fxsimulator.notificationservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
//@RequiredArgsConstructor
public class TestController {

    @Value("${spring.mail.username}")
    private String name;

    @Value("${spring.mail.password}")
    private String password;


    @GetMapping("/hello")
    public String sayHello() {
        return "Hello from API Gateway! \n" + name +"\n"+password+"\n" ;
    }
}
