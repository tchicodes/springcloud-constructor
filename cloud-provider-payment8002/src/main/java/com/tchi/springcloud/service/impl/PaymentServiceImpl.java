package com.tchi.springcloud.service.impl;

import com.tchi.springcloud.dao.PaymentMapper;
import com.tchi.springcloud.entity.Payment;
import com.tchi.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Yang Hao
 * @description
 * @date 2020-09-14 16:07
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentMapper paymentMapper;

    @Override
    public int create(Payment payment) {
        return paymentMapper.insert(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentMapper.selectByPrimaryKey(id);
    }
}
