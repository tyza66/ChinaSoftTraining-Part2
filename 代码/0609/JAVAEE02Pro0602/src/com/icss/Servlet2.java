package com.icss;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet2",urlPatterns = "/Servlet2")
public class Servlet2 extends HttpServlet {
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

//        完成注册功能  用户输入注册请求参数 Servlet（Controller 控制层 决定主体逻辑的调用）接收请求参数 --> service(复杂逻辑处理)-->dao层(数据库操作)
//        view --》 service --> dao（MVC Model 模型层(Java实体类 负责数据的传递)  V:View 视图(页面 jsp html)  C:Controller 控制层(Servlet)）

//        HttpServletResponse response 响应对象
//        响应对象乱码设置
        response.setContentType("text/html;charset=utf-8");
//        通过响应对象 获取输出流  可以向网页写内容
        /*PrintWriter out = response.getWriter();
        out.write("<h1>成功</h1>");*/

//        组件之间的跳转
//        响应重定向 发送两次请求  地址栏发生变化  不能携带参数到下一个组件
        request.setAttribute("uname",uname);
        response.sendRedirect("success.jsp");

//        请求转发 发送一次请求 地址栏不发生变化  能携带参数到下一个组件
//        request.getRequestDispatcher("success.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
