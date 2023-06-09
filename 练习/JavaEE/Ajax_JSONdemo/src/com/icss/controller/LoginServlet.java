package com.icss.controller;

import com.icss.pojo.Customer;
import com.icss.service.impl.CustomerServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet",urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        设置请求对象编码方式
//        request.setCharacterEncoding("utf-8");
//        获取请求参数 用户名和密码
        String cname = request.getParameter("cname");
        String cpwd = request.getParameter("cpwd");


//        登录功能  dao 根据用户名和密码进行查询
//        Controller（LoginServlet） --> service --> dao
        CustomerServiceImpl customerService = new CustomerServiceImpl();
        Customer customer = customerService.selectCusByNameAndPwd(cname, cpwd);
        if (customer != null) {
//        登录成功 跳转到主页面
            request.setAttribute("cname",cname);

//            登录成功后 用户名和密码保存在Cookie中 发送到客户端  (Cookie保存在客户端的小文本)
//            1 创建Cookie对象
   /*         Cookie nameCookie = new Cookie("cname",cname);
            Cookie pwdCookie = new Cookie("cpwd",cpwd);

            String t = request.getParameter("time");
            if (t != null && t.length() > 0) {
                //        获取有效时间
                int time = Integer.parseInt(t);
                System.out.println("time " + time);

//            Cookie有效时间： 如果不设置 默认是浏览器关闭 Cookie失效
//                           如果设置有效时间 setMaxAge(单位是秒)
                nameCookie.setMaxAge(time*24*60*60);
                pwdCookie.setMaxAge(time*24*60*60);

//           2 发送Cookie到客户端
                response.addCookie(nameCookie);
                response.addCookie(pwdCookie);
            }*/

            System.out.println("--------------------------session-------------------------");
//            获取session对象
            HttpSession session = request.getSession();

//            向session对象中存储登录成功名字
            session.setAttribute("cname",cname);

//            登录次数的统计
            System.out.println("------------------------------上下文对象---------------------------");
//            一个web应用程序 有唯一一个上下文对象
//            启动服务器，上下文对象被创建  关闭服务器，上下文对象被销毁
//            作用域范围：pageContext(页面范围) < request(请求) < session(会话) < servletContext(上下文对象)
//            获取上下文对象  ServletContext this.getServletContext()
//            设置属性：servletContext.setAttribute("key",Object); 获取属性：servletContext.getAttribute("key")
            ServletContext servletContext = this.getServletContext();
            int count = 0;
            Object obj = servletContext.getAttribute("count");
            if (obj == null) {
                count = 1;
            } else {
                count = Integer.parseInt(obj.toString());
                count++;
            }
            servletContext.setAttribute("count",count);


//            session的有效时间: ① 默认失效时间是30分钟 ② web.xml设置有效时间 ③setMaxInactiveInterval(单位是秒)
//            session.setMaxInactiveInterval(60);

            request.getRequestDispatcher("SelectAllCusServlet").forward(request,response);
        } else {
//            留在登录页面 错误提示
            request.setAttribute("msg","用户名或者密码输入错误,无法登录");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
