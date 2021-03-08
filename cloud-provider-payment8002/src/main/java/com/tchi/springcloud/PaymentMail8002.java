package com.tchi.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author: tianchi
 * @date: 2020-11-29
 * @description: 启动类
 **/
@SpringBootApplication
@EnableEurekaClient
public class PaymentMail8002 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMail8002.class, args);
    }

}
