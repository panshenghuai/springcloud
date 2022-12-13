package com.my.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author psh
 * @version 1.0
 * @date 2022/12/6 11:55
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication7002 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication7002.class,args);
    }
}
