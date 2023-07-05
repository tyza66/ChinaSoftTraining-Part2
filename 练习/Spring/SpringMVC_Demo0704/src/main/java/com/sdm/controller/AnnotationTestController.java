package com.sdm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Author: tyza66
 * Date: 2023/7/5 10:25
 * Github: https://github.com/tyza66
 **/

@Controller
//@RestController是一个复合租注解@Controller+@ResponseBody
public class AnnotationTestController {
    @RequestMapping("testRequestParam")
    @ResponseBody //使用这个主机的时候，方法的返回值就可以是返回的数据
    public String testRequestParam(@RequestParam("uname") String name, String pwd){
        System.out.println(name+" "+pwd);
        return "success";
    }

    @RequestMapping("deleteUserById/{uid}") //这个可以替换成GetMapping或者各种Mapping
    @ResponseBody //使用这个主机的时候，方法的返回值就可以是返回的数据
    public String deleteUserById(@PathVariable("uid") Integer uid){
        System.out.println(uid);
        return "success";
    }
}
