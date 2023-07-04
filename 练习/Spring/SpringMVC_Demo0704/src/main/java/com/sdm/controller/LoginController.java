package com.sdm.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Author: tyza66
 * Date: 2023/7/4 13:52
 * Github: https://github.com/tyza66
 **/

public class LoginController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        String uname = httpServletRequest.getParameter("uname");
        String pwd = httpServletRequest.getParameter("pwd");
        System.out.println(uname+" "+pwd);
        //负责数据的传递 View就是视图 Model就是模型
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("uname",uname);
        modelAndView.setViewName("success");
        return modelAndView;
    }
}
