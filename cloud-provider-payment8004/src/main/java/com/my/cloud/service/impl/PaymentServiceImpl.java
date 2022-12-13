package com.my.cloud.service.impl;

import com.my.cloud.entities.Payment;
import com.my.cloud.mapper.PaymentMapper;
import com.my.cloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author psh
 * @version 1.0
 * @date 2022/12/7 16:10
 */

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentMapper paymentMapper;

    @Override
    public Payment getPaymentById(Integer paymentId) {

        return paymentMapper.getPaymentById(paymentId);
    }
}
