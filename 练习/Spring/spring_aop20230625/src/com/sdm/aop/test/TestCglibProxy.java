package com.sdm.aop.test;

import com.sdm.aop.cglibProxy.CglibProxy;
import com.sdm.aop.cglibProxy.Target3;
import org.junit.Test;

/**
 * Author: tyza66
 * Date: 2023/6/26 10:13
 * Github: https://github.com/tyza66
 **/

public class TestCglibProxy {
    @Test
    public void test5(){
        CglibProxy cglibProxy = new CglibProxy();
        Object proxy = cglibProxy.getProxy(new Target3());
        Target3 proxy1 = (Target3) proxy;
        proxy1.giao3();
    }
}
