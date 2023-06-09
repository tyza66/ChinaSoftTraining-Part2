package com.icss.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.icss.pojo.Customer;
import com.icss.service.impl.CustomerServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet",urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        设置请求对象编码方式
//        request.setCharacterEncoding("utf-8");
//        获取请求参数 用户名和密码
        String cname = request.getParameter("cname");
        String cpwd = request.getParameter("cpwd");

//        登录功能  dao 根据用户名和密码进行查询
//        Controller（LoginServlet） --> service --> dao
        CustomerServiceImpl customerService = new CustomerServiceImpl();
        Customer customer = customerService.selectCusByNameAndPwd(cname, cpwd);
        //将数据以josn的形式返回给请求响应
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(response.getWriter(),customer);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
