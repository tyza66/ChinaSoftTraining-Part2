package com.icss.pojo;

import org.springframework.stereotype.Component;

@Component
public class Dog {
    private String dogName;
    private int dogAge;

    public Dog() {
        System.out.println("Dog无参数构造方法");
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
        System.out.println("setDogName");
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
