package com.my.cloud.controller;

import com.my.cloud.comment.CommentResult;
import com.my.cloud.entities.Payment;
import com.my.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
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

    @PostMapping(value = "/payment")
    public CommentResult insertPayment(Payment payment){
        log.info("Payment:"+payment);
        int result = paymentService.insertPayment(payment);
        if(result == 1){
            return new CommentResult(200,"success,port:"+serverPort,result);
        }else {
            return new CommentResult(404,"fail,port:"+serverPort,null);
        }
    }

    @GetMapping(value = "/payment/getString")
    public String getString(){
        return serverPort + ":" + UUID.randomUUID().toString();
    }

}
