package com.icss.test.controller;

import com.icss.test.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/*@Controller 控制层注解 */
@Controller
@RequestMapping("/user")//主路径
public class UserController {

//     @RequestMapping 请求映射
    @RequestMapping("/login.action")//子路径  /user/login.action
    public String login(HttpServletRequest request, Model model, HttpSession session){
        System.out.println("登录");
        System.out.println("请求参数 名字" + request.getParameter("uname"));
        System.out.println("请求参数  密码" + request.getParameter("pwd"));

//        request.setAttribute(); requestScope范围
        model.addAttribute("uname",request.getParameter("uname"));
//         获取session对象并设置值
        session.setAttribute("uname",request.getParameter("uname"));
//       上下文对象
        session.getServletContext().setAttribute("uname",request.getParameter("uname"));

        return "success";//视图名称
    }

    @RequestMapping("/testParams")
    public String testAccParams(String uname, Integer age){//方法形参:代表接收请求参数 保证页面name属性或者data中key 名称一致 完成类型转换
        System.out.println("名字 " + uname + " 年龄 " + age);
        return "success";
    }

    @RequestMapping("/testUser")
    public String testUserParam(User user){//页面参数name属性和user对象属性名称一致
        System.out.println("名字 " + user.getUname());
        System.out.println("user" + user);
        return  "success";
    }

//    方法返回值：① String类型数据 就是视图名称 就会经过视图解析器进行解析 完成响应
//              ② void 类型  可以借助HttpServletResponse响应对象 输出内容
//              ③ ModelAndView 通过ModelAndView对象设置视图名称 根据视图名称 经过视图解析器进行解析 完成响应

//     @RequestMapping 位置：类上 主路径  方法上 子路径 主路径/子路径
//     属性：value 规定请求后端的地址 {"请求地址1","请求地址2“}   如果只有一个请求地址 可以省略value
//          method 规定请求方式 代表只能按照规定的请求方式接收  如果不符合 405错误
//          params 规定请求参数 要求请求地址必须携带指定的参数
    @RequestMapping(value = {"/testDate","/addUser"},method = {RequestMethod.POST,RequestMethod.GET},params = {"uname"})
    public void testDate(User user, HttpServletResponse response) throws IOException {
//        System.out.println("日期 " + birthDate);
        System.out.println("user " + user);
//        return "success";
        response.getWriter().write("hello,world");
    }

}
