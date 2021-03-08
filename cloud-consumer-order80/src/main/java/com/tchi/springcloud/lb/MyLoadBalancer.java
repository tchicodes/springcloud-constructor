package com.tchi.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author: tianchi
 * @date: 2021-01-03
 * @description:
 **/
public interface MyLoadBalancer {

    ServiceInstance instances(List<ServiceInstance> serviceInstances);

}
