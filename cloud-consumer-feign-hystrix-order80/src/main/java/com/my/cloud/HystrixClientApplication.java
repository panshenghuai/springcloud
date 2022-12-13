package com.my.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author psh
 * @version 1.0
 * @date 2022/12/10 17:18
 */
@SpringBootApplication
@EnableFeignClients
@EnableCircuitBreaker
public class HystrixClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(HystrixClientApplication.class,args);
    }
}
