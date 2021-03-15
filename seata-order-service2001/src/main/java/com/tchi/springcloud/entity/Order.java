package com.tchi.springcloud.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private Long userId;

    private Long productId;

    private Integer count;

    private Long money;

    private Integer status = 0;
}