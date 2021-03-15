package com.tchi.springcloud.service.impl;

import com.tchi.springcloud.dao.StorageMapper;
import com.tchi.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class StorageServiceImpl implements StorageService {

    @Resource
    private StorageMapper storageMapper;

    @Override
    public void decrease(Long productId, Integer count) {
        log.info("------------->storage-service 中扣减库存开始");
        storageMapper.decrease(productId, count);
        log.info("------------->storage-service 中扣减库存结束");
    }

}
