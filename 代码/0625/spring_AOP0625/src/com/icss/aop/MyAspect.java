package com.icss.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 切面：与核心业务代码无关 且 又影响多个类的公共行为
 * @Component 对象
 * @Aspect 切面
 */
@Component
@Aspect
public class MyAspect {

    @Pointcut("execution(* com.icss.aop.UserDao.*(..))")
    public void pc(){

    }

//    前置通知
    @Before("pc()")
//     @Before("execution(* com.icss.aop.UserDao.*(..))")
    public void start(){
        System.out.println("开始执行...");
    }
    //JoinPoint 连接点  ret 方法的返回值接收 在xml文件中 指定returning="ret"
//    后置通知
    @AfterReturning(pointcut = "execution(* com.icss.aop.UserDao.*(..))",returning = "ret")
    public void end(JoinPoint joinPoint,Object ret){
        System.out.println("结束执行...");
        System.out.println("方法返回值 " + ret);
        System.out.println("获取目标对象 " + joinPoint.getTarget());
    }

//  JoinPoint joinPoint 连接点,Throwable e 接收目标对象产生的异常对象 在xml文件中 指定throwing="e"
//    异常通知
    @AfterThrowing(pointcut = "execution(* com.icss.aop.UserDao.*(..))",throwing = "e")
    public void testExceptionAdvice(JoinPoint joinPoint,Throwable e){
        System.out.println("异常通知...");
        System.out.println("获取异常的信息 " + e.getMessage());
    }

//    最终通知
    @After("execution(* com.icss.aop.UserDao.*(..))")
    public void testAfterAdvice(){
        System.out.println("最终通知...");
    }

//    环绕通知 :可以替换以上几种通知
    @Around("execution(* com.icss.aop.UserDao.*(..))")
    public void testAroundAdvice(ProceedingJoinPoint jp){
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
