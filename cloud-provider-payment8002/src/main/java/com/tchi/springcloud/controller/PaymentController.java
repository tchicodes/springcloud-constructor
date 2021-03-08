package com.tchi.springcloud.controller;

import com.tchi.springcloud.base.CommonResult;
import com.tchi.springcloud.entity.Payment;
import com.tchi.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author: tianchi
 * @date: 2020-05-11
 * @description:
 **/
@Slf4j
@RestController
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        if (result > 0) {
            return CommonResult.success(result);
        } else {
            return CommonResult.fail();
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        log.info("[查询订单] 查询订单ID：{}", id);
        Payment payment = paymentService.getPaymentById(id);
        if (payment != null) {
            return CommonResult.success(payment);
        } else {
            return CommonResult.fail();
        }
    }

    /**
     * openfeign超时测试
     * @return
     */
    @GetMapping(value = "/payment/feign/timeout")
    public String timeout() {
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "OK";
    }
}
