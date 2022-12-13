package com.my.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author psh
 * @version 1.0
 * @date 2022/12/12 17:41
 */
@SpringBootApplication
@EnableEurekaClient
public class GatewayClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayClientApplication.class,args);
    }
}
