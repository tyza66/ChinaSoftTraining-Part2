package com.sdm.pojo;

import org.springframework.stereotype.Component;

/**
 * Author: tyza66
 * Date: 2023/6/20 9:12
 * Github: https://github.com/tyza66
 **/

@Component("d5")//这里可以指定bean的id 如果不写就默认是类名首字母小写
public class Dog {
    private String dogName;
    private int dogAge;

    public Dog() {
        System.out.println("这个是Dog的无参数构造");
    }

    public Dog(String dogName, int dogAge) {
        this.dogName = dogName;
        this.dogAge = dogAge;
    }

    public String getDogName() {
        return dogName;
    }

    public void setDogName(String dogName) {
        this.dogName = dogName;
    }

    public int getDogAge() {
        return dogAge;
    }

    public void setDogAge(int dogAge) {
        this.dogAge = dogAge;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "dogName='" + dogName + '\'' +
                ", dogAge=" + dogAge +
                '}';
    }
}
