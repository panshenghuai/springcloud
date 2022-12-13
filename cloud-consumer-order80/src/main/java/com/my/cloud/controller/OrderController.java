package com.my.cloud.controller;

import com.my.cloud.comment.CommentResult;
import com.my.cloud.entities.Payment;
import com.my.cloud.lb.LoadBalance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.net.URL;
import java.util.List;

/**
 * @author psh
 * @version 1.0
 * @date 2022/12/5 16:34
 */

@RestController
@Slf4j
public class OrderController {

    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVER";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private DiscoveryClient discoveryClient;

    @Resource
    private LoadBalance loadBalance;

    @GetMapping(value = "/consumer")
    public CommentResult insertPayment(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment",payment,CommentResult.class);
    }

    @GetMapping(value = "/consumer/payment/{paymentId}")
    public CommentResult selectPaymentById(@PathVariable("paymentId") Long paymentId){
        log.info("consumer->payment->"+paymentId);
        return restTemplate.getForObject(PAYMENT_URL+"/payment?paymentId="+paymentId,CommentResult.class);
    }

    @GetMapping(value = "/consumer/payment/getEntity/{id}")
    public CommentResult getPayment(@PathVariable("id") Long id){
        ResponseEntity<CommentResult> entity = restTemplate.getForEntity(PAYMENT_URL+"/payment?paymentId="+id,CommentResult.class);
        log.info("entity:"+entity);
        if (entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody();
        }else {
            return new CommentResult(404,"false");
        }
    }

    @GetMapping(value = "/consumer/payment/lb")
    public String getPaymentLb(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVER");
        if (instances == null || instances.size()<=0){
            return null;
        }
        ServiceInstance serviceInstance = loadBalance.instances(instances);
        URI uri = serviceInstance.getUri();
        String s = restTemplate.getForObject(uri+"/payment/getString",String.class);
        log.info(s);
        return s;
    }
}
