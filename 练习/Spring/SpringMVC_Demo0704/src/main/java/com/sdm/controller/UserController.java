package com.sdm.controller;

import com.sdm.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

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
    //如果返回的是String类型的名称就是视图名称 就会经过视图解析器进行解析 完成响应
    //void类型 可以借助HttpServletResponse响应对象 使用输出流把东西响应在网页上
    //返回自定义ModelAndView
    @RequestMapping("/testDate")
    public void testDate(User user, HttpServletResponse response) throws IOException {
        System.out.println(user);
        response.getWriter().write("Hello,World!");
    }
}
