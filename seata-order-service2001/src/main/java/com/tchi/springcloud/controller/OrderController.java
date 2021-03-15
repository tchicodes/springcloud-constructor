package com.tchi.springcloud.controller;

import com.tchi.springcloud.base.CommonResult;
import com.tchi.springcloud.entity.Order;
import com.tchi.springcloud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: tianchi
 * @date: 2021-03-14
 * @description:
 **/
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult create(Order order)
    {
        orderService.create(order);
        return new CommonResult("200","订单创建成功");
    }

}
