package com.sdm.aop.testannotion;

import org.springframework.stereotype.Repository;

/**
 * Author: tyza66
 * Date: 2023/6/26 8:57
 * Github: https://github.com/tyza66
 **/

@Repository
public class Target1 {

    public String giao1(){
        System.out.println("giao1");
        return "giao1";
    }
}
