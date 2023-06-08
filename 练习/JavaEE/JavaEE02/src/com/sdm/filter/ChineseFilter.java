package com.sdm.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Author: tyza66
 * Date: 2023/6/8 10:18
 * Github: https://github.com/tyza66
 **/

@WebFilter(filterName = "ChineseFilter", urlPatterns = "/*")//指定要过滤的资源 /*表示所有资源
public class ChineseFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        System.out.println("对象初始化了");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
        System.out.println("对象销毁了");
    }
}
