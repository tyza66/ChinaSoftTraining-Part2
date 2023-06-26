package com.sdm.aop.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Author: tyza66
 * Date: 2023/6/26 9:41
 * Github: https://github.com/tyza66
 **/

public class JDKProxy implements InvocationHandler {
    //这个是代理的对象
    private Targrt2 targrt2;

    public Object getProxy(Targrt2 targrt2){
        this.targrt2 = targrt2;
        //获得本类的类加载器
        ClassLoader classLoader = JDKProxy.class.getClassLoader();

        //获取目标对象的所有接口
        Class[] interfaces = targrt2.getClass().getInterfaces();

        //生成代理类对象
        return Proxy.newProxyInstance(classLoader,interfaces,this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Aspect2 aspect21 = new Aspect2();
        aspect21.start();
        Object obj = method.invoke(targrt2, args);
        aspect21.end();
        return obj;
    }

}
