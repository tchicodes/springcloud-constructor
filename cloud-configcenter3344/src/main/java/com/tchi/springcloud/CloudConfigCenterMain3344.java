package com.tchi.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
public class CloudConfigCenterMain3344 {
    public static void main(String[] args) {
        SpringApplication.run(CloudConfigCenterMain3344.class, args);
    }
}
