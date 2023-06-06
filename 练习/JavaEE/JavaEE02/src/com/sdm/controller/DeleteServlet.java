package com.sdm.controller;
/**
 * Author: tyza66
 * Date: 2023/6/6 13:56
 * Github: https://github.com/tyza66
 **/

import com.sdm.service.impl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DeleteServlet", value = "/DeleteServlet")
public class DeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String id = request.getParameter("id");
        CustomerServiceImpl sc = new CustomerServiceImpl();
        Boolean aBoolean = sc.deleteOne(Integer.parseInt(id));
        PrintWriter writer = response.getWriter();
        if (aBoolean){
            writer.println("<script>alert('删除成功！');window.location.href='index.jsp'</script>");
        }else{
            writer.println("<script>alert('删除失败！');window.location.href='index.jsp'</script>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
