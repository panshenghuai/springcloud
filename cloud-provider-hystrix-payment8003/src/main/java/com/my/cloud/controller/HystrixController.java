package com.my.cloud.controller;

import com.my.cloud.service.HystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author psh
 * @version 1.0
 * @date 2022/12/10 16:18
 */

@RestController
@Slf4j
public class HystrixController {

    @Autowired
    private HystrixService hystrixService;

    @Value("${server.port}")
    private String port;

    @GetMapping(value = "/payment/hystrix/ok/{id}")
    public String hystrixOk(@PathVariable("id") Integer id) {
        String rs = hystrixService.hystrixOk(id);
        log.info(port+":/payment/hystrix/timeout/"+id+rs);
        return rs;
    }

    @GetMapping(value = "/payment/hystrix/timeout/{id}")
    public String hystrixTimeOut(@PathVariable("id") Integer id) {
        String rs = hystrixService.hystrixTimeOut(id);
        log.info(port+":/payment/hystrix/timeout/"+id+rs);
        return rs;
    }

    @GetMapping(value = "/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        String rs = hystrixService.paymentCircuitBreaker(id);
        log.info(port+":/payment/hystrix/timeout/"+id+rs);
        return rs;
    }

}
