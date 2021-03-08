package com.tchi.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author: tianchi
 * @date: 2020-11-29
 * @description: 启动类
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class PaymentMail8001 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMail8001.class, args);
    }

}
