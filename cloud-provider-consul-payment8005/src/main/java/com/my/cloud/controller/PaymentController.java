package com.my.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author psh
 * @version 1.0
 * @date 2022/12/7 18:10
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/consul")
    public String getPayment(){
        return "consulServer=>"+serverPort+ UUID.randomUUID().toString();
    }
}
