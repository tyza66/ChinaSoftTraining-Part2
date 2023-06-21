package com.sdm.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Author: tyza66
 * Date: 2023/6/21 9:43
 * Github: https://github.com/tyza66
 **/

@Component
@Scope(value = "singleton")
@Lazy //懒加载模式 只有getBean的时候才会被创建 （单例模式）
public class Account {

    @Value("1001")
    private int aid;

    @Value("小明")
    private String name;

    @Value("1000")
    private String money;

    public Account() {
        System.out.println("Account被创建了");
    }

    public Account(int aid, String name, String money) {
        this.aid = aid;
        this.name = name;
        this.money = money;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "aid=" + aid +
                ", name='" + name + '\'' +
                ", money='" + money + '\'' +
                '}';
    }
}
