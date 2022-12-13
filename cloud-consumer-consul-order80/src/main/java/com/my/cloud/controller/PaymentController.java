package com.my.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author psh
 * @version 1.0
 * @date 2022/12/7 18:26
 */
@RestController
public class PaymentController {

    private static String CONSUL_URL = "http://cloud-provider-consul-payment";

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/consul")
    public String getPayment(){

        return restTemplate.getForObject(CONSUL_URL+"/payment/consul",String.class);
    }


}
