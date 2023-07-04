package com.icss.test.controller;

import com.icss.test.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
    public String testAccParams(String uname,Integer age){
        System.out.println("名字 " + uname + " 年龄 " + age);
        return "success";
    }

    @RequestMapping("/testUser")
    public String testUserParam(User user){//页面参数name属性和user对象属性名称一致
        System.out.println("名字 " + user.getUname());
        return  "success";
    }
}
