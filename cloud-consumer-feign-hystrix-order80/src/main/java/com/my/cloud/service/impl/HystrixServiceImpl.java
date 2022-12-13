package com.my.cloud.service.impl;

import com.my.cloud.service.HystrixService;
import org.springframework.stereotype.Component;

/**
 * @author psh
 * @version 1.0
 * @date 2022/12/11 13:40
 */
@Component
public class HystrixServiceImpl implements HystrixService {
    @Override
    public String hystrixTimeOut(Integer id) {
        return "====hystrixTimeOutFallback====";
    }

    @Override
    public String hystrixOk(Integer id) {
        return "====hystrixOkFallback====";
    }
}
