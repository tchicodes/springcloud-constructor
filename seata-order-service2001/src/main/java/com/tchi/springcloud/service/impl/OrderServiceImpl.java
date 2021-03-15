package com.tchi.springcloud.service.impl;

import com.tchi.springcloud.dao.OrderMapper;
import com.tchi.springcloud.entity.Order;
import com.tchi.springcloud.feign.AccountService;
import com.tchi.springcloud.feign.StorageService;
import com.tchi.springcloud.service.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author: tianchi
 * @date: 2021-03-14
 * @description:
 **/
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private AccountService accountService;
    @Autowired
    private StorageService storageService;

    @Override
    @GlobalTransactional(name = "my_test_tx_group", rollbackFor = Exception.class)
    public void create(Order order) {

        log.info("----->开始新建订单");
        //新建订单
        orderMapper.insert(order);

        //扣减库存
        log.info("----->订单微服务开始调用库存，做扣减Count");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("----->订单微服务开始调用库存，做扣减end");

        //扣减账户
        log.info("----->订单微服务开始调用账户，做扣减Money");
        accountService.decrease(order.getUserId(), BigDecimal.valueOf(order.getMoney()));
        log.info("----->订单微服务开始调用账户，做扣减end");


        //修改订单状态，从零到1代表已经完成
        log.info("----->修改订单状态开始");
        orderMapper.update(order.getUserId(), 0);
        log.info("----->修改订单状态结束");

        log.info("----->下订单结束了");

    }

}
