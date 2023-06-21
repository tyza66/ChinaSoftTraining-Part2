package com.sdm.pojo;

import org.springframework.stereotype.Component;

/**
 * Author: tyza66
 * Date: 2023/6/21 9:43
 * Github: https://github.com/tyza66
 **/

@Component
public class Account {

    private int aid;

    private String name;

    private String money;

    public Account() {
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
