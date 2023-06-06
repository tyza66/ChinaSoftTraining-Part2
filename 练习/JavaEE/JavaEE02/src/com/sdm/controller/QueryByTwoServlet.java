package com.sdm.controller;
/**
 * Author: tyza66
 * Date: 2023/6/6 18:24
 * Github: https://github.com/tyza66
 **/

import com.sdm.pojo.Customer;
import com.sdm.service.ICustomService;
import com.sdm.service.impl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "QueryByTwoServlet", value = "/QueryByTwoServlet")
public class QueryByTwoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String username = request.getParameter("name");
        String age = request.getParameter("age");
        System.out.println(username+" "+ age);
        ICustomService is =  new CustomerServiceImpl();
        List<Customer> customers = is.selectCusByTwo(username, age);
        System.out.println(customers.size());
        PrintWriter writer = response.getWriter();
        for(Customer c:customers){
            writer.println(c);
        }
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
