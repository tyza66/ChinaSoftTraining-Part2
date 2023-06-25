package com.icss.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理对象 jdk代理
 */
public class JDKProxy implements InvocationHandler {

//    接口类型 目标对象
    private IUserDao userDao;

//    创建代理方法
    public Object createProxy(IUserDao userDao){
        this.userDao = userDao;

//        获取类加载器
        ClassLoader classLoader = JDKProxy.class.getClassLoader();
//        获取目标对象的所有接口
        Class[] interfaces = userDao.getClass().getInterfaces();

//        生成代理类对象
        return Proxy.newProxyInstance(classLoader,interfaces,this);

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        创建切面对象
        MyAspect myAspect = new MyAspect();
        myAspect.start();
        Object obj = method.invoke(userDao, args);
        myAspect.end();
        return obj;
    }
}

