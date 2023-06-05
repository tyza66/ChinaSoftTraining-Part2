package com.sdm.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Author: tyza66
 * Date: 2023/06/02 14:51:59
 * Github: https://github.com/tyza66
 **/

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String uname = request.getParameter("uname");
        String pwd = request.getParameter("pwd");
        String[] hobby = request.getParameterValues("hobby");//获得请求的单数 返回的是一个数组
        if(hobby!= null && hobby.length != 0){
            for (String tmp:hobby){
                System.out.println(tmp);
            }
        }
        System.out.println(uname + " " + pwd + " " + hobby);

        //servlet充当的是Controller层
        //VIEW -> SERVICE -> DAO
        //使用这个把东西返回给视图层
        PrintWriter writer = response.getWriter();
        writer.println("<h1>success</h1>");
        //MVC 模型层（java对象） 视图层（前端页面） 控制层（servlet）

        //组件之间的跳转

        //响应重定向 不能携带参数到下一个组件
        request.setAttribute("uname", uname);
        //response.sendRedirect("success.jsp");

        //请求转发 可以携带参数到下一个组件
        request.getRequestDispatcher("success.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String uname = request.getParameter("uname");
        String pwd = request.getParameter("pwd");
        String[] hobby = request.getParameterValues("hobby");//获得请求的单数 返回的是一个数组
        if(hobby!= null && hobby.length != 0){
            for (String tmp:hobby){
                System.out.println(tmp);
            }
        }
        System.out.println(uname + " " + pwd);
    }

}
