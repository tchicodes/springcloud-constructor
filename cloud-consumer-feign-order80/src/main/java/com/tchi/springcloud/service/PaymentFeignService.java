package com.tchi.springcloud.service;

import com.tchi.springcloud.base.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author: tianchi
 * @date: 2021-01-03
 * @description:
 **/
@Component
@FeignClient(name = "CLOUD-PAYMENT-SERVICE", contextId = "payment1")
public interface PaymentFeignService {

    @GetMapping(value = "/payment/get/{id}")
    CommonResult getPaymentById(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/feign/timeout")
    String paymentFeignTimeOut();
}
