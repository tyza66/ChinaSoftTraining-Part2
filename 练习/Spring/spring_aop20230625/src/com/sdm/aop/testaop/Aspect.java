package com.sdm.aop.testaop;

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

    public void afterReturning(){
        System.out.println("afterReturning...");
    }

    public void afterThrowing(){
        System.out.println("afterThrowing...");
    }

    public void around(){
        System.out.println("around...");
    }
}
