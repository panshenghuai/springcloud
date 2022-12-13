package com.my.cloud.service;

import com.my.cloud.service.impl.HystrixServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author psh
 * @version 1.0
 * @date 2022/12/10 17:25
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-HYSTRIX-SERVER",fallback = HystrixServiceImpl.class)
public interface HystrixService {

    @GetMapping(value = "/payment/hystrix/timeout/{id}")
    String hystrixTimeOut(@PathVariable("id") Integer id);

    @GetMapping(value = "/payment/hystrix/ok/{id}")
    String hystrixOk(@PathVariable("id") Integer id);

}
