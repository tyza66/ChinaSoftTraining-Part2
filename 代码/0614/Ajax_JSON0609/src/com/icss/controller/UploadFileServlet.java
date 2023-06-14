package com.icss.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

@WebServlet(name = "UploadFileServlet",urlPatterns = "/UploadFileServlet")
@MultipartConfig
public class UploadFileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        获取上传者名字
        String username = request.getParameter("username");
//        获取文件
        Part file = request.getPart("file");

        System.out.println("文件名称 " + file.getSubmittedFileName());


        String fn = file.getSubmittedFileName();

//        如果上传相同的名字的图片 会发生覆盖
//        解决办法:1 时间戳  2 uuid UUID.randomUUID()
        long time = new Date().getTime();

        String path = "D:\\upload";

        File f = new File(path);
        if (!f.exists()) {
            f.mkdirs();
        }

        if (fn.toLowerCase().endsWith(".jpg") || fn.toLowerCase().endsWith(".png")) {
            file.write(path + "/" + time + fn.substring(fn.lastIndexOf(".")));
        }

//        数据库中创建表(上传名字 存储文件的 旧 新名字)
//        向表中插入一行记录

//        查询所有的信息 在页面中看到所有上传图片

        response.getWriter().write(fn);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
