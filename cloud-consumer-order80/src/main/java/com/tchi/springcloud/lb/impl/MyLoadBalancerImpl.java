package com.tchi.springcloud.lb.impl;

import com.tchi.springcloud.lb.MyLoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author: tianchi
 * @date: 2021-01-03
 * @description:
 **/
@Service
@Slf4j
public class MyLoadBalancerImpl implements MyLoadBalancer {

    private static AtomicInteger sum = new AtomicInteger(0);

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = getInstanceIndex() % serviceInstances.size();
        return serviceInstances.get(index);
    }

    private int getInstanceIndex() {
        int curr, next;
        do {
            curr = sum.get();
            next = curr >= Integer.MAX_VALUE ? 0 : curr + 1;
        } while (!sum.compareAndSet(curr, next));
        log.info("第{}次访问", next);
        return next;
    }
}
