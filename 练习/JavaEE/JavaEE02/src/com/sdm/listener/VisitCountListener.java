package com.sdm.listener;

import com.sdm.dao.impl.CustomerDaoImpl;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Author: tyza66
 * Date: 2023/6/8 14:41
 * Github: https://github.com/tyza66
 **/

@WebListener
public class VisitCountListener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {
    //一个web应用有一个唯一的上下文对象 放我们启动服务器的时候上下文对象被创建 关闭服务器的时候上下文对象被销毁
    //作用于范围：pageContext页面范围 request请求 session会话 application上下文对象
    //在过滤器中可以使用request.getServletContext()获取上下文对象
    //在监听器中可以使用sce.getServletContext()获取上下文对象
    //监听器的作用：监听对象的创建和销毁
    //监听器的使用场景：统计网站的访问量
    //监听器的使用步骤：1.创建一个类实现监听器接口 2.在web.xml中配置监听器
    //监听器的分类：ServletContextListener监听上下文对象的创建和销毁
    //HttpSessionListener监听会话对象的创建和销毁
    //HttpSessionAttributeListener监听会话对象中属性的添加、删除、替换
    //ServletRequestListener监听请求对象的创建和销毁
    //ServletRequestAttributeListener监听请求对象中属性的添加、删除、替换
    //监听器的生命周期：监听器的生命周期由服务器来管理
    //application对象是jsp内置对对象 就是上下文对象
    //设置application对象或上下文对象的的属性：setAttribute("key","value");

    public VisitCountListener() {
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        /* This method is called when the servlet context is initialized(when the Web application is deployed). */
        System.out.println("上下文对象初始化了");
        //这个时候要从数据库里面读取来上次访问量多少次
        CustomerDaoImpl cd = new CustomerDaoImpl();
        int visitorCount = cd.getVisitorCount();
        sce.getServletContext().setAttribute("times",visitorCount);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        /* This method is called when the servlet Context is undeployed or Application Server shuts down. */
        System.out.println("上下文对象销毁了");
        //这里面把访问量存到数据库里面 进行持久化
        CustomerDaoImpl cd = new CustomerDaoImpl();
        cd.setVisitorCount((int)sce.getServletContext().getAttribute("times"));
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is added to a session. */
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is removed from a session. */
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is replaced in a session. */
    }
}
