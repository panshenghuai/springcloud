package com.my.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author psh
 * @version 1.0
 * @date 2022/12/5 14:34
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentServerApplication8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentServerApplication8001.class,args);
    }
}
