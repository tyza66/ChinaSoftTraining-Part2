package com.sdm.controller;
/**
 * Author: tyza66
 * Date: 2023/6/6 13:58
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
import java.io.PrintWriter;

@WebServlet(name = "UpdateServlet", value = "/UpdateServlet")
public class UpdateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String cid = request.getParameter("id");
        String cname = request.getParameter("name");
        String cpwd = request.getParameter("password");
        String cage = request.getParameter("age");
        CustomerServiceImpl sc = new CustomerServiceImpl();
        Boolean aBoolean = sc.updateOne(new Customer(Integer.parseInt(cid), cname, cpwd, cage));
        PrintWriter writer = response.getWriter();
        if (aBoolean){
            writer.println("<script>alert('修改成功！');window.location.href='index.jsp'</script>");
        }else {
            writer.println("<script>alert('修改失败！');window.location.href='index.jsp'</script>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
