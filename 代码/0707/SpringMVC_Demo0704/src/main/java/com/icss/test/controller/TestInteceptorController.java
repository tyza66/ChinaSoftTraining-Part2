package com.icss.test.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class TestInteceptorController {

    @PostMapping("/login")
    public String login(String uname, String pwd, HttpSession session){
        System.out.println("接收请求参数 " + uname  + "--- " + pwd);
//        登录成功 名字存储在session中
        session.setAttribute("uname",uname);
        return "success";
    }
}
