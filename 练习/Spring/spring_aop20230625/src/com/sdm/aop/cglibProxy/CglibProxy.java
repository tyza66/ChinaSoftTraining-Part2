package com.sdm.aop.cglibProxy;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Author: tyza66
 * Date: 2023/6/26 10:02
 * Github: https://github.com/tyza66
 **/

public class CglibProxy implements MethodInterceptor {

    public Object getProxy(Target3 target3){
        //创建动态类对象 创建增强器
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target3.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    /*
        Object o：表示被代理的目标对象
        Method method：表示被代理的目标方法
        Object[] objects：表示被代理的目标方法的参数
        MethodProxy methodProxy：表示代理对象，可以用它来调用目标方法
    */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Aspect3 aspect3 = new Aspect3();
        aspect3.start();
        //调用代理类的方法
        Object obj = methodProxy.invokeSuper(o, objects);
        aspect3.end();
        return obj;
    }
}
