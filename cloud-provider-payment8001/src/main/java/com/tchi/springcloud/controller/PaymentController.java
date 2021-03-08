package com.tchi.springcloud.controller;

import com.tchi.springcloud.base.CommonResult;
import com.tchi.springcloud.entity.Payment;
import com.tchi.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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
    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        log.info("[创建订单] 开始创建订单。。。");
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

    @GetMapping(value = "/payment/info")
    public void info() {
        for (String service: discoveryClient.getServices()) {
            log.info("SERVICE INFO: {}", service);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance serviceInstance : instances) {
            log.info("INSTANCE INFO: {}-{}-{}-{}",
                    serviceInstance.getHost(), serviceInstance.getPort(), serviceInstance.getUri(), serviceInstance.getMetadata());
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

    @GetMapping("/payment/zipkin")
    public String paymentZipkin() {
        return "hi,I am payment_zipkin server fall back, welcome to";
    }

}
