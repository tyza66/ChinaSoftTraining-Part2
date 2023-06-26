package com.sdm.aop.test;

import com.sdm.aop.jdkProxy.JDKProxy;
import com.sdm.aop.jdkProxy.Targrt2;
import com.sdm.aop.jdkProxy.Targrt2Impl;
import org.junit.Test;

/**
 * Author: tyza66
 * Date: 2023/6/26 9:52
 * Github: https://github.com/tyza66
 **/

public class tsetJDKProxy {
    @Test
    public void test4(){
        JDKProxy jdkProxy = new JDKProxy();
        Object proxy = jdkProxy.getProxy(new Targrt2Impl());
        Targrt2 proxy1 = (Targrt2) proxy;
        proxy1.giao2();
    }
}
