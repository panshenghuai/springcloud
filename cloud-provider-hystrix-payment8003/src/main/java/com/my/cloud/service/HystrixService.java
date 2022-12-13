package com.my.cloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author psh
 * @version 1.0
 * @date 2022/12/10 16:08
 */

@Service
public class HystrixService {

    public String hystrixOk(Integer id) {
        return "当前线程:{" + Thread.currentThread().getName() + "}，id是："+id+"，调用成功！";
    }

    @HystrixCommand(fallbackMethod = "hystrixTimeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000")
    })
    public String hystrixTimeOut(Integer id){
        //int num = 1/0;
        int time = 1;
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  "当前线程:{" + Thread.currentThread().getName() + "}，id是："+id+"，超时调用成功！超时"+time+"ms";
    }
    public String hystrixTimeOutHandler(Integer id){

        return "服务调用超时或异常，请稍后重试！id="+id;
    }


    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),//失败率达标后多少跳闸
    })
    public String paymentCircuitBreaker(Integer id) {
        if(id < 0)
        {
            throw new RuntimeException("******id 不能负数");
        }
        String serialNumber = UUID.randomUUID().toString();

        return Thread.currentThread().getName()+"\t"+"调用成功，流水号: " + serialNumber;
    }

    public String paymentCircuitBreakerFallback(@PathVariable("id") Integer id)
    {
        return "id 不能负数，请稍后再试，id: " +id;
    }

}
