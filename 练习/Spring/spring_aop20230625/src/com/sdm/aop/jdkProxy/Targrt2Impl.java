package com.sdm.aop.jdkProxy;

/**
 * Author: tyza66
 * Date: 2023/6/26 9:38
 * Github: https://github.com/tyza66
 **/

public class Targrt2Impl implements Targrt2{
    @Override
    public String giao2() {
        System.out.println("giao2");
        return "giao2";
    }
}
