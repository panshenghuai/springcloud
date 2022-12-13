package com.my.cloud.service;

import com.my.cloud.entities.Payment;

/**
 * @author psh
 * @version 1.0
 * @date 2022/12/5 15:02
 */
public interface PaymentService {

    Payment selectPaymentById(Long paymentId);

    int insertPayment(Payment payment);
}
