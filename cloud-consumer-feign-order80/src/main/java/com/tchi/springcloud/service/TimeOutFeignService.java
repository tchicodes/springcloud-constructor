package com.tchi.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: tianchi
 * @date: 2021-01-03
 * @description:
 **/
@Component
@FeignClient(name = "CLOUD-PAYMENT-SERVICE", contextId = "payment2")
public interface TimeOutFeignService {

    @GetMapping(value = "/payment/feign/timeout")
    String paymentFeignTimeOut();

}
