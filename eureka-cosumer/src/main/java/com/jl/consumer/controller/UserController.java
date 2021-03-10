package com.jl.consumer.controller;


import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserController {

    @Resource(name = "eurekaClient")
    private EurekaClient eurekaClient;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/getUserInfo")
    public String getUserInfo() {

        List<InstanceInfo> instanceList = eurekaClient.getInstancesByVipAddress("eureka-provider", false);
        InstanceInfo instanceInfo = instanceList.get(0);
        String url = "http://" + instanceInfo.getHostName() + ":" + instanceInfo.getPort() + "/getUserInfo";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        System.out.println("response=" + response);
        return "getUserInfo";
    }


    @GetMapping(value = "/getUsername")
    public String getUsername() {
        ServiceInstance instance = loadBalancerClient.choose("eureka-provider");
        String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/getUsername";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        System.out.println(response);
        return "getUserInfo";
    }

    @GetMapping(value = "/ribbon")
    public String ribbon(){
        //todo 如果有同名方法名会怎样？试了一下好像是调用后启动的provider的方法
        String url = "http://eureka-provider/ribbon";
        return restTemplate.getForObject(url, String.class);
    }
}
