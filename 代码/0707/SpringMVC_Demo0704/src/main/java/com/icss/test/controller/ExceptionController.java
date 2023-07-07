package com.icss.test.controller;

import com.icss.test.exception.MyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionController {

    @RequestMapping("/testExcetion1")
    public String testException1(){
//        如果产生异常 则可以跳转到一个统一页面
        System.out.println(1/0);
        return "success";
    }


    @GetMapping("/testExcetion2")
    public String testExcetion2(){
       /* int[] arr = new int[2];
        System.out.println("获取最后一个数组的元素" + arr[2]);*/

        System.out.println(1/0);
        return "success";
    }

//    @ExceptionHandler 捕获当前controller类中发生异常
    @ExceptionHandler({ArrayIndexOutOfBoundsException.class,ArithmeticException.class})
    public String handleException(Exception e){
        System.out.println("异常的信息 " + e.getMessage());
//        e.printStackTrace();
        return "fail" + e.getMessage();
    }

    @RequestMapping("/testExcetion3")
    public String testExcetion3() throws MyException {
//        产生自定义异常
        throw new MyException("发生了自定义异常....");
    }
}
