package com.icss.test.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        System.out.println("处理登录请求");
//        获取请求参数
        String uname = httpServletRequest.getParameter("uname");
        String pwd = httpServletRequest.getParameter("pwd");

        System.out.println("name = " + uname + " pwd = " + pwd);

//      ModelAndView Model 模型层  负责数据传递  View 视图
        ModelAndView modelAndView = new ModelAndView();
//        传递数据 requestScope范围
        modelAndView.addObject("uname",uname);
//       设置视图名称
        modelAndView.setViewName("success");

        return modelAndView;
    }
}
