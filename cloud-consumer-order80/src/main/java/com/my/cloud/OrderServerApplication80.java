package com.my.cloud;

import com.my.myrule.MyRuler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author psh
 * @version 1.0
 * @date 2022/12/5 16:27
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "CLOUD-PAYMENT-SERVER",configuration = MyRuler.class)
public class OrderServerApplication80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderServerApplication80.class,args);
    }
}
