package com.sdm.controller;

import com.sdm.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Author: tyza66
 * Date: 2023/7/4 14:22
 * Github: https://github.com/tyza66
 **/

@Controller
public class UserController {

    @RequestMapping("/login2.action")
    public String login(HttpServletRequest request, Model model, HttpSession session){
        System.out.println("账号"+request.getParameter("uname"));
        System.out.println("密码"+request.getParameter("pwd"));
        //request.setAttribute requestScope范围
        model.addAttribute("uname",request.getParameter("uname"));
        //session
        session.setAttribute("uname",request.getParameter("uname"));
        //上下文对象
        session.getServletContext().setAttribute("uname",request.getParameter("uname"));
        return "success";//视图名称
    }

    @RequestMapping("/testParams")
    public String testAccParams(String uname,Integer age){
        System.out.println("名字"+uname);
        System.out.println("年龄"+age);
        return "success";
    }

    @RequestMapping("/testUser")
    public String testUser(User user){
        System.out.println(user);
        return "success";
    }
}
