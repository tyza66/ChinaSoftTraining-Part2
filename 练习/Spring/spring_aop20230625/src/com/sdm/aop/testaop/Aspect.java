package com.sdm.aop.testaop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Author: tyza66
 * Date: 2023/6/26 8:20
 * Github: https://github.com/tyza66
 **/

public class Aspect {

    public void start(){
        System.out.println("start...");
    }

    public void end(){
        System.out.println("end...");
    }

    public void afterReturning(JoinPoint joinPoint,Object result){
        System.out.println("afterReturning...");
        System.out.println("方法返回值 " + result);
        System.out.println("获取目标对象 " + joinPoint.getTarget());
    }

    public void afterThrowing(JoinPoint joinPoint, Throwable e){
        System.out.println("afterThrowing...");
        System.out.println("获取异常的信息 " + e.getMessage());
    }

    public void around(ProceedingJoinPoint jp){
        try {
            System.out.println("前置通知...");
            Object proceed = jp.proceed();
            System.out.println("后置通知...");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("异常通知...");
        } finally {
            System.out.println("最终通知....");
        }

        System.out.println("......这是环绕通知......");
    }
}
