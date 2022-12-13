package cloud.controller;

import com.my.cloud.comment.CommentResult;
import com.my.cloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;

/**
 * @author psh
 * @version 1.0
 * @date 2022/12/5 16:34
 */

@RestController
@Slf4j
public class OrderZookeeperController {

    private static final String PAYMENT_URL = "http://cloud-zookeeper-server";

    @Resource
    private RestTemplate restTemplate;



    @GetMapping(value = "/consumer/payment")
    public String selectPaymentById(@PathParam("paymentId") Long paymentId){
        log.info("consumer->payment->"+paymentId);

        return restTemplate.getForObject(PAYMENT_URL+"/payment/zookeeper",String.class);
    }
}
