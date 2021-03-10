package com.jl.provider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {

    @Value("${server.port}")
    private String port;


    @GetMapping(value = "/getUserInfo")
    public String getUserInfo(){
        return "user1";
    }


    @GetMapping(value = "/getUsername")
    public String getUsername(){
        return "调用的provider的端口是：" + port;
    }

    @GetMapping(value = "/ribbon")
    public String ribbon(){
        return "XXXXXXXXXXXXXribbon调用的provider的端口是：" + port;
    }


    @GetMapping(value = "/feign")
    public String feign(){
        return "feign";
    }
}
