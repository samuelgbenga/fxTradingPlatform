package com.fxsimulator.usermanagementservice;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
//@RequiredArgsConstructor
public class TestController {

    @Value("${cloudinary.api-key}")
    private String key;

    @Value("${cloudinary.api-secret}")
    private String secret;

    @Value("${cloudinary.cloud-name}")
    private String name;

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello from API Gateway! \n" + name +"\n"+secret+"\n"+key ;
    }
}
