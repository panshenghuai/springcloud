package com.my.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author psh
 * @version 1.0
 * @date 2022/12/6 18:36
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ZookeeperServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZookeeperServerApplication.class,args);
    }
}
