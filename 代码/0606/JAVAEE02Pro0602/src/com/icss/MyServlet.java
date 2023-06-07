package com.icss;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet的生命周期:
 * 创建Serlvet对象 执行构造方法(1次) 单实例 访问Servlet的时候创建
 * 初始化Servlet对象 执行init()方法(1次)
 * 执行service()方法,在这个方法中获取请求方式，根据请求方式决定调用doGet()方法或者doPost()方法 （发送请求有多少次执行多少次）
 * 销毁Servlet实例  执行destroy()方法  停止服务
 *
 * Servlet是单实例多线程
 *
 */
@WebServlet(name = "MyServlet",urlPatterns = "/MySerlvet")
public class MyServlet extends HttpServlet {

    public MyServlet(){
        System.out.println("MyServlet的构造方法");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("service方法的调用");
//        super.service(req, resp);
        String method = req.getMethod();
        if ("GET".equals(method)) {
            doGet(req,resp);
        }else if ("POST".equals(method)) {
            doPost(req,resp);
        }
    }

    @Override
    public void destroy() {
        System.out.println("Servlet的销毁");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("Servlet的初始化");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet");
    }






}
