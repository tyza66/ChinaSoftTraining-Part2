package com.icss.controller;

import com.icss.pojo.Customer;
import com.icss.service.impl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateCusByIdServlet",urlPatterns = "/UpdateCusByIdServlet")
public class UpdateCusByIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
//        获取请求参数
        int cid = Integer.parseInt(request.getParameter("cid"));
        String cname = request.getParameter("cname");
        String cpwd = request.getParameter("cpwd");
        int cage = Integer.parseInt(request.getParameter("cage"));

        boolean flag = new CustomerServiceImpl().updateCusById(new Customer(cid,cname,cpwd,cage));

        if (flag) {
            request.setAttribute("msg","修改成功");
        } else {
            request.setAttribute("msg","修改失败");
        }

        request.getRequestDispatcher("SelectAllCusServlet").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
