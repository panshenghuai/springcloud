package com.my.cloud.controller;

import com.my.cloud.comment.CommentResult;
import com.my.cloud.service.OrderFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author psh
 * @version 1.0
 * @date 2022/12/10 13:28
 */
@RestController
@Slf4j
public class FeignPaymentController {

    @Autowired
    private OrderFeignService feignService;

    @GetMapping(value = "/consumer/feign/{paymentId}")
    public CommentResult selectPaymentById(@PathVariable("paymentId") Long paymentId){
        log.info("/payment/feign/"+paymentId);
        return feignService.selectPaymentById(paymentId);
    }
}
