package com.icss.controller;

import com.icss.pojo.Customer;
import com.icss.service.impl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SelectAllCusServlet",urlPatterns = "/SelectAllCusServlet")
public class SelectAllCusServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> list  = new CustomerServiceImpl().selectAllCustomer();

        request.setAttribute("list",list);

        request.getRequestDispatcher("main.jsp").forward(request,response);
    }
}
