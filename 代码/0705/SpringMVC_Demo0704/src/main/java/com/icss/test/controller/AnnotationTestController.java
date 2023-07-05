package com.icss.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController //复合注解 包含 @Controller  @ResponseBody
//@Controller
public class AnnotationTestController {

    @RequestMapping("/testRequestParam")
//    @ResponseBody 代表方法的返回值就是响应的数据
//    @ResponseBody
//    @RequestParam("uname") 处理传递参数名称和接收请求方法的参数名称不一致情况
    public String testRequestParam(@RequestParam("uname") String name,String pwd){
        System.out.println("请求参数 " + name +  " 密码 " + pwd);
        return "success";
    }

//    原来的请求地址：deleteUserById?uid=1
//    现在请求地址：deleteUserById/1
    @RequestMapping(value="/deleteUserById/{uid}",method = RequestMethod.GET)//{uid} 占位符

//     @RequestMapping(value="/deleteUserById/{uid}",method = RequestMethod.GET)
//    替换为  @GetMapping("/deleteUserById/{uid}")

//    restful编程风格
//    @GetMapping("/deleteUserById/{uid}")  查询
//    @PostMapping("/user")   保存数据
//    @DeleteMapping("/user/{uid}")  删除  deleteUserById/1
//    @PutMapping("/user")    修改
    public String testPathVariable(@PathVariable("uid") Integer uid){
        System.out.println("uid " + uid);
        return "success";
    }

}
