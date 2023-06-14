package com.icss.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.icss.service.impl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteSelectedByIdsServlet",urlPatterns = "/DeleteSelectedByIdsServlet")
public class DeleteSelectedByIdsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        获取选中的用户编号
        String[] ids = request.getParameterValues("ids");

        boolean flag = new CustomerServiceImpl().deleteSelectedByIds(ids);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(response.getWriter(),flag);

    }
}
