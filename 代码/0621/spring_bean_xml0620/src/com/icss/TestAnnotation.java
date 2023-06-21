package com.icss;

import com.icss.controller.AccountController;
import com.icss.dao.impl.AccountDaoImpl;
import com.icss.pojo.Dog;
import com.icss.service.impl.AccountServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Component(value="bean中id名称") 类 用于创建对象  value可以省略  也可以不指定名称 默认生成名称 类名首字母小写
 * @Repository(value = "accountDao") Dao层类  用于创建对象  value可以省略  也可以不指定名称 默认生成名称 类名首字母小写
 *
 */
public class TestAnnotation {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-annotation.xml");

        Dog dog = (Dog)applicationContext.getBean("dog");

        System.out.println("dog " + dog);

        /*AccountDaoImpl accountDao = (AccountDaoImpl) applicationContext.getBean("accountDao");
        accountDao.selectAccountDao();*/


        /*AccountServiceImpl accountService = (AccountServiceImpl)applicationContext.getBean("accountServiceImpl");
        accountService.selectAccountDao();*/


        AccountController accountController = (AccountController) applicationContext.getBean("accountController");
        accountController.selectAccount();

        applicationContext.close();

    }
}
