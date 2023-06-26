package com.icss.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 与表对应的实体类
 *  model 模型 负责数据的传递
 */
@Component
//@Scope(value = "singleton") 单例模式 @Scope(value = "prototype") 原型模式
//@Scope(value = "prototype")
// @Lazy 延迟加载 （单例模式）
@Lazy
public class Account {
//    账户id
    @Value("1001")
    private int aid;
//    名字
    @Value("tom")
    private String name;
//    余额
    @Value("1000")
    private int money;
// @PostConstruct 初始化方法

    @PostConstruct
    public void init(){
        System.out.println("初始化方法");
    }
// @PreDestroy 销毁方法
    @PreDestroy
    public void destroy(){
        System.out.println("销毁方法");
    }

    public Account() {
        System.out.println("Account的无参数构造方法");
    }

    public Account(int aid, String name, int money) {
        this.aid = aid;
        this.name = name;
        this.money = money;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
        System.out.println("setAid()");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "aid=" + aid +
                ", name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}
