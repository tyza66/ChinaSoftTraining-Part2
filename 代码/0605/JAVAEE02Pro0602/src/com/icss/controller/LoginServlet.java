package com.icss.controller;

import com.icss.pojo.Customer;
import com.icss.service.impl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet",urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        设置请求对象编码方式
        request.setCharacterEncoding("utf-8");
//        获取请求参数 用户名和密码
        String cname = request.getParameter("cname");
        String cpwd = request.getParameter("cpwd");

//        登录功能  dao 根据用户名和密码进行查询
//        Controller（LoginServlet） --> service --> dao
        CustomerServiceImpl customerService = new CustomerServiceImpl();
        Customer customer = customerService.selectCusByNameAndPwd(cname, cpwd);
        if (customer != null) {
//        登录成功 跳转到主页面
            request.setAttribute("cname",cname);
            request.getRequestDispatcher("main.jsp").forward(request,response);
        } else {
//            留在登录页面 错误提示
            request.setAttribute("msg","用户名或者密码输入错误,无法登录");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
