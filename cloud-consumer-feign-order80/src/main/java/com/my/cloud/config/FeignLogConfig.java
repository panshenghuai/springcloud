package com.my.cloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author psh
 * @version 1.0
 * @date 2022/12/10 14:47
 */
@Configuration
public class FeignLogConfig {

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.BASIC;
    }
}
