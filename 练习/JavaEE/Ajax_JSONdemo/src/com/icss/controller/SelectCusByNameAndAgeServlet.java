package com.icss.controller;
/**
 * Author: tyza66
 * Date: 2023/6/14 9:49
 * Github: https://github.com/tyza66
 **/

import com.fasterxml.jackson.databind.ObjectMapper;
import com.icss.pojo.Customer;
import com.icss.service.impl.CustomerServiceImpl;
import com.icss.util.Pager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "SelectCusByNameAndAgeServlet",urlPatterns = "/SelectCusByNameAndAgeServlet")
public class SelectCusByNameAndAgeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        获取用户输入的名字
        String cname = request.getParameter("cname");
//        年龄
        String cage = request.getParameter("cage");
//        当前页
        int currpage = Integer.parseInt(request.getParameter("currpage"));
        System.out.println("cname = " + cname+" cage = " + cage+" currpage = " + currpage);

//       2 创建service对象
        CustomerServiceImpl customerService = new CustomerServiceImpl();

//      3 构建pager对象
        Pager pager = new Pager(currpage,customerService.getCusByNameAndAgeCount("%"+cname+"%",cage));

//      4 按照用户点击的页码进行查询
        List<Customer> list  = customerService.selectCusByNameAndAge("%"+cname+"%",cage,pager.getStart(),pager.getStart() + pager.getPageSize() - 1);

        response.setContentType("text/html;charset=utf-8");

        Map<String,Object> map = new HashMap<>();
        map.put("list",list);//显示当前页的数据
        map.put("pager",pager);//页码

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(response.getWriter(),map);



    }
}
