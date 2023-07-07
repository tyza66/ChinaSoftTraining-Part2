package com.icss.test.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MyInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle 处理规定资源的请求 返回true 则继续处理(找到下一个拦截器/响应数据) 才会执行postHandle");
        String url = request.getRequestURL().toString();
        System.out.println("url " + url);
//        登录验证逻辑
//        1 判断url  /login.html /login.action register.html register.action 允许通过
        String[] arr = {"login.html","/login","register.html","/register"};
        boolean flag = false;
        for(String item : arr){
            if (url.indexOf(item) != -1) {
                flag =true;
                break;
            }
        }
        System.out.println("flag " + flag);
//        2 登录成功 session获取存储登录信息不为null 允许通过
        HttpSession session = request.getSession();
        System.out.println("项目部署路径  " + request.getContextPath());
//        3 以上条件不满足 进行拦截 跳转到登录页面
        if (flag || session.getAttribute("uname") != null ) {
            return true;
        } else {
            response.sendRedirect("http://localhost:8081/login.html");
            return false;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle 执行 视图渲染之前执行");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("清理资源操作....");
    }
}
