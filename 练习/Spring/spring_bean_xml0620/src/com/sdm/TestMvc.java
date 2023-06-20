package com.sdm;

import com.sdm.controller.AccountController;
import com.sdm.service.AccountService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Author: tyza66
 * Date: 2023/6/20 13:33
 * Github: https://github.com/tyza66
 **/

public class TestMvc {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-mvc.xml");
        AccountController accountController = (AccountController)context.getBean("accountController");
        accountController.play();
        context.close();
    }
}
