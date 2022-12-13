package com.my.cloud.controller;

import com.my.cloud.service.HystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @author psh
 * @version 1.0
 * @date 2022/12/10 17:31
 */

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "globalFallbackHandler")
public class HystrixController {

    @Value("${server.port}")
    private String port;

    @Resource
    private HystrixService hystrixService;

    @GetMapping(value = "/payment/hystrix/ok/{id}")
    public String hystrixOk(@PathVariable("id") Integer id){
        String rs = hystrixService.hystrixOk(id);
        log.info("端口："+port+"结果："+rs);
        return rs;
    }

    @HystrixCommand(fallbackMethod = "timeoutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000")
    })
    @GetMapping(value = "/payment/hystrix/timeout/{id}")
    public String hystrixTimeOut(@PathVariable("id") Integer id){
        String rs = hystrixService.hystrixTimeOut(id);
        log.info("端口："+port+"结果："+rs);
        return rs;
    }
    public String timeoutHandler(Integer id){

        return "服务80调用超时，请稍后重试！,id="+id;
    }
    public String globalFallbackHandler(){

        return "globalFallback!";
    }

}
