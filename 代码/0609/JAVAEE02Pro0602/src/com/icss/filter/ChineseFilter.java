package com.icss.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/*
* 创建过滤器
* 1 实现Filter接口 重写接口中抽象方法
* 2 添加@WebFilter(filterName = "ChineseFilter",urlPatterns = "/*")注解
* urlPatterns 规定过滤的资源路径 /* 项目中所有的资源  /admin admin文件夹下所有的资源 *.jsp jsp文件
* */
//@WebFilter(filterName = "ChineseFilter",urlPatterns = "/*")
public class ChineseFilter implements Filter {
    public void destroy() {
        System.out.println("ChineseFilter对象销毁");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
//        System.out.println("处理具体过滤内容doFilter");
        req.setCharacterEncoding("utf-8");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("ChineseFilter对象初始化");

    }

}
