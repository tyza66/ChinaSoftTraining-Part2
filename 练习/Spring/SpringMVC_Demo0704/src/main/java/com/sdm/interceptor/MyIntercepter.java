package com.sdm.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Author: tyza66
 * Date: 2023/7/7 11:07
 * Github: https://github.com/tyza66
 **/

public class MyIntercepter implements HandlerInterceptor {
    //主要方法逻辑写在这里
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("处理我们规定资源的请求 返回true继续处理（找到下一个拦截器/响应数据）才去执行postHandle");
        //可以将验证登录的逻辑写这里
        //可以将判断url啥的也写这里
        //登录状态和登录信息
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle在视图渲染之前执行");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
