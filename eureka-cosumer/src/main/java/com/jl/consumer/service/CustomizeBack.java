package com.jl.consumer.service;

public class CustomizeBack implements UserService{
    @Override
    public String feign() {
        return "服务降级中。。。。";
    }
}
