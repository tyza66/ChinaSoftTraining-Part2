package com.icss.listener;

import com.icss.service.impl.CustomerServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.io.*;

@WebListener
public class VisitCountListener implements ServletContextListener {

    File file = new File("D:\\javaee02\\count.txt");

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
        /*BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            String count = br.readLine();

            sce.getServletContext().setAttribute("count",count);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }*/
        /*int count = new CustomerServiceImpl().getCount();
        sce.getServletContext().setAttribute("count",count);*/
    }

    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
      */
        System.out.println("上下文对象销毁--关闭服务器");
//        获取上下文对象存储的count次数 持久化保存下来(1 写入文件 2 存入数据库)
//        获取上下文对象
        ServletContext servletContext = sce.getServletContext();
//        缓冲区字符流
//       1 描述文件

//        2 构建缓冲区字符流对象
/*        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(file));
//            3 写 内容 (从上下文对象获取count次数)
            bw.write(servletContext.getAttribute("count").toString());

//            4 刷新缓冲流
            bw.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }*/

      /* boolean flag = new CustomerServiceImpl().updateCount(Integer.parseInt(servletContext.getAttribute("count").toString()));
        System.out.println("flag = " + flag);*/
    }

}
