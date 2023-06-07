package com.sdm.controller;
/**
 * Author: tyza66
 * Date: 2023/6/5 10:51
 * Github: https://github.com/tyza66
 **/

import com.sdm.pojo.Customer;
import com.sdm.service.ICustomService;
import com.sdm.service.impl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    private ICustomService is = new CustomerServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String cname = request.getParameter("cname");
        String cpwd = request.getParameter("cpwd");
        CustomerServiceImpl customerService = new CustomerServiceImpl();
        Customer customer = is.selectCusByNameAndPwd(cname, cpwd);
        if (customer != null) {
            request.setAttribute("customer", customer);
        } else {
            request.setAttribute("customer", null);
        }
        List<Customer> all = is.getAll();
        request.setAttribute("all", all);

        Cookie cookie = new Cookie("giao", "giao");
        cookie.setMaxAge(30*60);
        response.addCookie(cookie);
        request.getRequestDispatcher("main.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
