package com.tchi.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author: tianchi
 * @date: 2021-01-03
 * @description:
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class OpenFeignOrder80 {
    public static void main(String[] args) {
        SpringApplication.run(OpenFeignOrder80.class, args);
    }
}
