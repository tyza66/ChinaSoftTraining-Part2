package com.sdm.controller;
/**
 * Author: tyza66
 * Date: 2023/6/5 14:49
 * Github: https://github.com/tyza66
 **/

import com.sdm.pojo.Customer;
import com.sdm.service.impl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "RegisterServlet2", value = "/RegisterServlet2")
public class RegisterServlet2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        CustomerServiceImpl customerService = new CustomerServiceImpl();
        String cid = request.getParameter("cid");
        String cname = request.getParameter("cname");
        String cpwd = request.getParameter("cpwd");
        String cage = request.getParameter("cage");
        Boolean end = customerService.insertOne(new Customer(Integer.parseInt(cid), cname, cpwd, cage));
        if (end) {
            request.setAttribute("status", "ok");
        } else {
            request.setAttribute("status", "fail");
        }
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
