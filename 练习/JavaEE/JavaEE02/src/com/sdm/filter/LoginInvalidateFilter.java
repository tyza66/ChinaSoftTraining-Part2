package com.sdm.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Author: tyza66
 * Date: 2023/6/8 10:52
 * Github: https://github.com/tyza66
 **/

@WebFilter(filterName = "LoginInvalidateFilter", urlPatterns = "/*")//指定要过滤的资源 /*表示所有资源
public class LoginInvalidateFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        System.out.println("L过滤器对象初始化了");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("L过滤器处理内容");
        //用户没有登录的时候判断请求的url 根据请求的url进行判断 如果这些资源是需要登录才能访问的 那就跳转到登陆界面
        servletRequest.setCharacterEncoding("UTF-8");
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        System.out.println(request.getRequestURL());//请求地址
        System.out.println(request.getRequestURI());//请求资源
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
        System.out.println("L过滤器对象销毁了");
    }
}

