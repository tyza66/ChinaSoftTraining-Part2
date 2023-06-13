package com.icss.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.icss.service.impl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteCusByIdServlet",urlPatterns = "/DeleteCusByIdServlet")
public class DeleteCusByIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//  获取cid
        int cid = Integer.parseInt(request.getParameter("cid"));

        boolean flag  = new CustomerServiceImpl().deleteCusById(cid);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(response.getWriter(),flag);
    }
}
