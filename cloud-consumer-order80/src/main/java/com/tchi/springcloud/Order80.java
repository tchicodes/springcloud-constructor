package com.tchi.springcloud;

import com.tchi.rule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author: tianchi
 * @date: 2020-12-06
 * @description:
 **/
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration = MySelfRule.class)
public class Order80 {

    public static void main(String[] args) {
        SpringApplication.run(Order80.class, args);
    }

}
