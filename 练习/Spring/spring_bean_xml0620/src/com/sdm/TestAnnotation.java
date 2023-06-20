package com.sdm;

import com.sdm.controller.AccountController;
import com.sdm.dao.AccountDao;
import com.sdm.pojo.Dog;
import com.sdm.service.AccountService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Author: tyza66
 * Date: 2023/6/20 14:23
 * Github: https://github.com/tyza66
 **/

public class TestAnnotation {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-annotation.xml");
        Dog d5 = (Dog) applicationContext.getBean("d5");
        System.out.println(d5);

        AccountDao accountDao = (AccountDao)applicationContext.getBean("accountDao");
        accountDao.getDog();

        AccountService accountService = (AccountService)applicationContext.getBean("accountServiceImpl");
        accountService.selectAccount();

        AccountController accountController = (AccountController)applicationContext.getBean("accountController");

        accountController.play();
        applicationContext.close();
    }
}
