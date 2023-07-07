package com.sdm.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Author: tyza66
 * Date: 2023/7/7 9:57
 * Github: https://github.com/tyza66
 **/

//处理全局的异常
@ControllerAdvice //控制器增强
public class GlobalExceptionHandler {

    @ExceptionHandler({Exception.class})
    @ResponseBody
    public String testException(Exception e){
        System.out.println(e.getMessage());
        return "fail";
    }
}
