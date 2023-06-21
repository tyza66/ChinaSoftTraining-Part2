package com.icss.pojo;

/**
 * 普通工厂
 */
public class CustomerFactory {
//    生产产品对象
    public Product getPro(){
        return new Product();
    }
}
