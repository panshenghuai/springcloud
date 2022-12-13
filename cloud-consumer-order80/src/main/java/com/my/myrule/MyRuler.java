package com.my.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author psh
 * @version 1.0
 * @date 2022/12/8 14:59
 */
@Configuration
public class MyRuler {
    @Bean
    public IRule myRule(){
        //定义随机
        return new RandomRule();
    }
}
