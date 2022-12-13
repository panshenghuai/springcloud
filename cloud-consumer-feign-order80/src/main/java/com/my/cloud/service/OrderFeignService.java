package com.my.cloud.service;

import com.my.cloud.comment.CommentResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author psh
 * @version 1.0
 * @date 2022/12/10 13:24
 */

@FeignClient(value = "CLOUD-PAYMENT-SERVER")
public interface OrderFeignService {
    @GetMapping(value = "/payment/{paymentId}")
    public CommentResult selectPaymentById(@PathVariable("paymentId") Long paymentId);
}
