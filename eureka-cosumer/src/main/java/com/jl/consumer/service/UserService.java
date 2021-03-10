package com.jl.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
@FeignClient(name = "eureka-provider",fallback = CustomizeBack.class)
public interface UserService {

    @GetMapping(value = "/feign")
    String feign();
}
