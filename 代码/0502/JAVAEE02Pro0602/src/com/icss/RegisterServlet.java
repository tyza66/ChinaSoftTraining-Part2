package com.icss;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterServlet",urlPatterns = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        获取请求参数  请求对象 HttpServletRequest request
//        request.getParameter(页面控件的name属性名称) 返回String类型数据
//        post请求 发送中文数据 乱码 设置请求编码方式
        request.setCharacterEncoding("utf-8");
//        获取姓名
        String uname = request.getParameter("uname");
        String pwd = request.getParameter("pwd");

        System.out.println("姓名 " + uname + " 密码 " + pwd);


//        request.getParameterValues("name属性") 返回String[]数组  获取前端页面同一个name属性对应多个值
        String[] hs = request.getParameterValues("hobby");
        if (hs != null && hs.length != 0) {
            for (String tmp : hs) {
                System.out.println("选择的爱好 " + tmp);
            }
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
