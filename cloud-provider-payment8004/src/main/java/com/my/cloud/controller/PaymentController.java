package com.my.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author psh
 * @version 1.0
 * @date 2022/12/6 18:53
 */
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @Autowired


    @GetMapping(value = "/payment/zookeeper")

    public String paymentZookeeper(){
        return "spring-cloud-zookeeper:"+serverPort + UUID.randomUUID().toString();
    }
}
