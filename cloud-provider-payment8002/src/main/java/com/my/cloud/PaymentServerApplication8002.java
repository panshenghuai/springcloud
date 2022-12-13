package com.my.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author psh
 * @version 1.0
 * @date 2022/12/6 13:52
 */

@SpringBootApplication
@EnableEurekaClient
public class PaymentServerApplication8002 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentServerApplication8002.class,args);
    }
}
