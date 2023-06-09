package com.icss.controller;

import com.icss.pojo.Customer;
import com.icss.service.impl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterServlet",urlPatterns = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

//        获取请求参数
//        用户姓名
        String cname = request.getParameter("cname");
//        用户密码
        String cpwd = request.getParameter("cpwd");
//        用户年龄
        int cage = Integer.parseInt(request.getParameter("cage"));

//        注册功能  要求用户名不能重复 如果重复则注册失败 不重复增加用户信息
        boolean flag = new CustomerServiceImpl().registerCustomer(new Customer(cname,cpwd,cage));
        if (flag) {
            request.getRequestDispatcher("login.jsp").forward(request,response);
        } else {
            request.setAttribute("msg","注册失败");
            request.getRequestDispatcher("register.jsp").forward(request,response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
