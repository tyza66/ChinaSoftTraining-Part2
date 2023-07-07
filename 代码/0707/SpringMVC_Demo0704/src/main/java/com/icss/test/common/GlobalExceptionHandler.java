package com.icss.test.common;

import com.icss.test.exception.MyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局处理发生的异常
 *
 * @ControllerAdvice 控制器增强
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String textException(Exception e){
        System.out.println("异常的信息" + e.getMessage());
        return "fail" + e.getMessage();
    }

//    可以添加具体异常(例如数学异常 自定义异常(业务异常))捕获的方法..

//    创建一个自定义异常  控制层方法 抛出自定义异常  在全局处理 处理自定义异常方法
    @ExceptionHandler(MyException.class)
    @ResponseBody
    public String testMyExceptionHandle(MyException myException){
        System.out.println("自定义异常的信息 " + myException.getMessage());
        return "fail";
    }
}
