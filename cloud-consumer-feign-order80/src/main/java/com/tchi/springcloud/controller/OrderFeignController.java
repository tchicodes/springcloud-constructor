package com.tchi.springcloud.controller;

import com.tchi.springcloud.base.CommonResult;
import com.tchi.springcloud.service.PaymentFeignService;
import com.tchi.springcloud.service.TimeOutFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: tianchi
 * @date: 2021-01-03
 * @description:
 **/
@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;
    @Resource
    private TimeOutFeignService timeOutFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping(value = "/consumer/payment/feign/timeout1")
    public String paymentFeignTimeOut1() {
        return paymentFeignService.paymentFeignTimeOut();
    }

    @GetMapping(value = "/consumer/payment/feign/timeout2")
    public String paymentFeignTimeOut2() {
        return timeOutFeignService.paymentFeignTimeOut();
    }
}