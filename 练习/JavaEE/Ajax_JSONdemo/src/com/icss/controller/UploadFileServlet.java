package com.icss.controller;
/**
 * Author: tyza66
 * Date: 2023/6/14 13:58
 * Github: https://github.com/tyza66
 **/

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;

@WebServlet(name = "UploadFileServlet", value = "/UploadFileServlet")
@MultipartConfig
public class UploadFileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取到上传者的名子
        String username = request.getParameter("userName");
        System.out.println("上传者：" + username);
        Part file = request.getPart("file");
        System.out.println("文件名称：" + file.getSubmittedFileName());
        String fn = file.getSubmittedFileName();
        String path = "D:\\Project\\ChinaSoftTraining-Part2\\练习\\JavaEE\\Ajax_JSONdemo\\files";
        File f = new File(path);
        if (!f.exists()) {
            f.mkdirs();
        }
        //可以用时间戳或者uuid进行区分同名文件
        if(fn.toLowerCase().endsWith(".jpg") || fn.toLowerCase().endsWith(".png") || fn.toLowerCase().endsWith(".gif")) {
            file.write(path + File.separator + fn);
        }

        response.getWriter().write(fn);
    }

}
