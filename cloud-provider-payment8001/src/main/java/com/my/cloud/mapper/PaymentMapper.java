package com.my.cloud.mapper;

import com.my.cloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author psh
 * @version 1.0
 * @date 2022/12/5 14:51
 */

@Mapper
public interface PaymentMapper {
    /**
     * 新增payment
     * @param  payment payment
     * @return int
     */
    public int insertPayment(Payment payment);

    /**
     * 通过id查Payment
     * @param paymentId paymentId
     * @return Payment类
     */
    public Payment selectPaymentById(@Param("paymentId") Long paymentId);
}
