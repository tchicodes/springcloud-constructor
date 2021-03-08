package com.tchi.springcloud.service;

import com.tchi.springcloud.entity.Payment;

public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(Long id);

}
