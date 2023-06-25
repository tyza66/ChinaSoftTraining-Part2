package com.icss.jdkProxy;

/**
 * 切面：与核心业务代码无关 且 又影响多个类的公共行为
 */
public class MyAspect {
    public void start(){
        System.out.println("开始执行...");
    }

    public void end(){
        System.out.println("结束执行...");
    }
}
