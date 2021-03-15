package com.tchi.springcloud.feign;

import com.tchi.springcloud.base.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: tianchi
 * @date: 2021-03-14
 * @description:
 **/
@FeignClient(value = "seata-storage-service")
public interface StorageService {

    @PostMapping(value = "/storage/decrease")
    CommonResult decrease(@RequestParam(value = "productId") Long productId, @RequestParam(value = "count") Integer count);

}
