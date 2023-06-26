package com.sdm.pojo;

/**
 * Author: tyza66
 * Date: 2023/6/26 14:50
 * Github: https://github.com/tyza66
 **/

public class Student {
    private int sid;
    private String sname;
    private String gender;
    private int city;

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getCity() {
        return city;
    }

    public void setCity(int city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", gender='" + gender + '\'' +
                ", city=" + city +
                '}';
    }
}
