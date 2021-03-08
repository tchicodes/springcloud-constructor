package com.tchi.springcloud.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: tianchi
 * @date: 2020-05-11
 * @description:
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult {

    private static final String SUCCESS = "A0000";
    private static final String FAIL = "E0000";

    private String code;
    private String message;
    private Object data;

    public CommonResult(String code, String message) {
        this(code, message, null);
    }

    public static CommonResult success(Object data){
        CommonResult result = new CommonResult();
        result.setCode(SUCCESS);
        result.setData(data);
        result.setMessage("success");
        return result;
    }

    public static CommonResult fail(){
        CommonResult result = new CommonResult();
        result.setCode(FAIL);
        result.setMessage("fail");
        return result;
    }
}
