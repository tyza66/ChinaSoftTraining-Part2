package com.icss.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.icss.pojo.Customer;
import com.icss.service.impl.CustomerServiceImpl;
import com.icss.util.Pager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@WebServlet(name = "SelectAllCusServlet",urlPatterns = "/SelectAllCusServlet")
public class SelectAllCusServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取当前的页面
        int i = Integer.parseInt(request.getParameter("currpage"));

        CustomerServiceImpl customerService = new CustomerServiceImpl();

        Pager pager = new Pager(i, customerService.getCustomerCount());

        List<Customer> customerListByPage = customerService.getCustomerListByPage(pager.getStart(), pager.getStart() - 1 + pager.getPageSize());
        /*List<Customer> list  = new CustomerServiceImpl().selectAllCustomer();
        System.out.println(list);*/

        //request.setAttribute("list",customerListByPage);

        /*request.getRequestDispatcher("main.jsp").forward(request,response);*/
        //将数据以josn的形式返回给请求响应


        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("list",customerListByPage);
        objectObjectHashMap.put("pager",pager);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(response.getWriter(),objectObjectHashMap);
    }
}
