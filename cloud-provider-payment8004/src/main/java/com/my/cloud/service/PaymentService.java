package com.my.cloud.service;

import com.my.cloud.entities.Payment;

/**
 * @author psh
 * @version 1.0
 * @date 2022/12/7 16:09
 */
public interface PaymentService {

    Payment getPaymentById(Integer paymentId);

}
