package com.my.cloud.controller;

import com.my.cloud.comment.CommentResult;
import com.my.cloud.entities.Payment;
import com.my.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;
import java.util.List;
import java.util.UUID;

/**
 * @author psh
 * @version 1.0
 * @date 2022/12/5 15:01
 */

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping(value = "/payment/get/{paymentId}")
    public CommentResult selectPaymentById(@PathVariable("paymentId") Long paymentId){
        log.info("selectPayment,paymentId:"+paymentId);
        Payment payment = paymentService.selectPaymentById(paymentId);
        if (payment!=null){
            return new CommentResult(200,"success,port:"+serverPort,payment);
        }else {
            return new CommentResult(404,"fail,port:"+serverPort+",paymentId:"+paymentId);
        }

    }

    @PostMapping(value = "/payment/lb")
    public CommentResult insertPayment(Payment payment){
        log.info("Payment:"+payment);
        int result = paymentService.insertPayment(payment);
        if(result == 1){
            return new CommentResult(200,"success,port:"+serverPort,result);
        }else {
            return new CommentResult(404,"fail,port:"+serverPort,null);
        }
    }

    @GetMapping(value = "/payment/discovery")
    public Object discoveryClient(){
        List<String> services = discoveryClient.getServices();
        for (String s: services) {
            log.info("===>"+s);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVER");
        for (ServiceInstance instance : instances) {
            log.info("getInstanceId:"+instance.getInstanceId()+"\n"
            +"ServiceId:"+instance.getServiceId()+"\n"
            +"Port:"+instance.getPort()+"\n"
            +"Host:"+instance.getHost()+"\n"
            +"URL:"+instance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping(value = "/payment/getString")
    public String getString(){
        log.info(serverPort+":/payment/getString");
        return serverPort + ":" + UUID.randomUUID();
    }
}
