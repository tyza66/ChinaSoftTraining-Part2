package com.sdm.aop.test;

import com.sdm.aop.testaop.Target;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Author: tyza66
 * Date: 2023/6/26 8:21
 * Github: https://github.com/tyza66
 **/

public class test1 {

    @Test
    public void testAop1(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");

        Target target = applicationContext.getBean("target", Target.class);

        target.giao();
    }

}
