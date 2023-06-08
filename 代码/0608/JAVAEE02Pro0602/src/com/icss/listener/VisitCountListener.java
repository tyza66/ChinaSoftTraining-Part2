package com.icss.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class VisitCountListener implements ServletContextListener {

    // Public constructor is required by servlet spec
    public VisitCountListener() {
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
      /* This method is called when the servlet context is
         initialized(when the Web application is deployed). 
         You can initialize servlet context related data here.
      */
        System.out.println("上下文创建--启动服务器");
//        从文件或者数据库中获取count次数 存储在上下文对象中
    }

    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
      */
        System.out.println("上下文对象销毁--关闭服务器");
//        获取上下文对象存储的count次数 持久化保存下来(1 写入文件 2 存入数据库)
//        获取上下文对象
        sce.getServletContext();
    }


}
