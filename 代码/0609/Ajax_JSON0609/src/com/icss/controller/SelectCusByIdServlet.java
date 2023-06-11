package com.icss.controller;

import com.icss.pojo.Customer;
import com.icss.service.impl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SelectCusByIdServlet",value = "/SelectCusByIdServlet")
public class SelectCusByIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        获取当前点击哪行的用户编号
        int cid = Integer.parseInt(request.getParameter("cid"));

        Customer customer = new CustomerServiceImpl().selectCusById(cid);

        request.setAttribute("customer",customer);

        request.getRequestDispatcher("updateCus.jsp").forward(request,response);


    }
}
