package com.icss;

import com.icss.controller.AccountController;
import com.icss.dao.impl.AccountDaoImpl;
import com.icss.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMVC {
    public static void main(String[] args) {
//        初始化spring容器
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-mvc.xml");

        /*AccountDaoImpl accountDao = (AccountDaoImpl)applicationContext.getBean("accountDao");
        accountDao.selectAccountDao();*/

        /*AccountServiceImpl accountService = (AccountServiceImpl)applicationContext.getBean("accountService");
        accountService.selectAccountDao();*/

        AccountController accountController = (AccountController)applicationContext.getBean("accountController");
        accountController.selectAccount();

//        关闭容器
        applicationContext.close();

    }
}
