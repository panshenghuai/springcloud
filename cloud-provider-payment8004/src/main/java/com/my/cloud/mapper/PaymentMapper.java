package com.my.cloud.mapper;

import com.my.cloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author psh
 * @version 1.0
 * @date 2022/12/7 16:09
 */

@Mapper
public interface PaymentMapper {

    Payment getPaymentById(@Param("paymentId") Integer paymentId);
}
