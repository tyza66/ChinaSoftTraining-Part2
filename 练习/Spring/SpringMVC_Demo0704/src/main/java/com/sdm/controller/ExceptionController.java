package com.sdm.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: tyza66
 * Date: 2023/7/7 9:06
 * Github: https://github.com/tyza66
 **/

@RestController
public class ExceptionController {
    @RequestMapping("/testException")
    public String testException(){
        //如果产生了异常可以跳转到一个统一的页面
        System.out.println(1/0);
        return "success";
    }

    @ExceptionHandler({ArrayIndexOutOfBoundsException.class, ArithmeticException.class})
    public String handleException(Exception e){
        System.out.println("异常信息是："+e);
        return "fail";
    }
}
