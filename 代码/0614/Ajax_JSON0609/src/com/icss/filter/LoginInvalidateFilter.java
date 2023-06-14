package com.icss.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebFilter(filterName = "LoginInvalidateFilter",urlPatterns = "/*",dispatcherTypes = {DispatcherType.REQUEST,DispatcherType.FORWARD})
public class LoginInvalidateFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
//        登录验证
//        ① 用户没有登录 判断请求的URL 访问资源 如果这些资源是["login.jsp","LoginServlet","register.jsp","RegisterServlet“,"/css","/js"]可以放行
//        ② 登录之后 获取session对象存储的值 如果有 则可以放行
//       以上条件不满足 则回到登录页面
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;
        System.out.println("请求地址" + request.getRequestURL());//http://localhost:8081/JAVAEE02Pro0602_war_exploded/login.jsp
        System.out.println("请求地址2 " + request.getRequestURI());///JAVAEE02Pro0602_war_exploded/login.jsp
        String uri = request.getRequestURI();
        String[] arr = {"login.jsp","LoginServlet","register.jsp","RegisterServlet","/css","/js"};
        boolean flag = false;
        for (String tmp : arr) {
            if (uri.contains(tmp)) {
                flag = true;
                break;
            }
        }

        if (flag ||  request.getSession().getAttribute("cname") != null) {
            chain.doFilter(req, resp);
        } else {
            response.sendRedirect("login.jsp");
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
