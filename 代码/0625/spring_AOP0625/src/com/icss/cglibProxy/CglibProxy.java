package com.icss.cglibProxy;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib代理
 */
public class CglibProxy implements MethodInterceptor {

//    创建代理对象
    public Object createProxy(Object target){//参数 目标对象
//        创建动态类对象
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
//        创建切面对象
        MyAspect myAspect = new MyAspect();
        myAspect.start();
        Object obj = methodProxy.invokeSuper(o,objects);
        myAspect.end();
        return obj;
    }
}
