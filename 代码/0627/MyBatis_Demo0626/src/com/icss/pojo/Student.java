package com.icss.pojo;

/**
 * Mybatis几乎消除了所有的jdbc操作(设置参数以及获取结果集)
 * 核心思想： ORM(对象关系映射) MyBatis 自动映射
 * ORM(对象关系映射)  数据库中的一张表对应java一个类  表中字段对应java的属性  表中一行记录对应java中一个对象
 * 自动映射：要求表中字段名称和java中类中属性名称一致
 */
public class Student {
//    学号
    private int sid;
    private String sname;
    private String gender;
    private String city;

    public int getSid() {
        return sid;
    }

    /**
     * 设置学号
     * @param sid 学号
     */
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Student() {
    }

    public Student(int sid, String sname, String gender, String city) {
        this.sid = sid;
        this.sname = sname;
        this.gender = gender;
        this.city = city;
    }

    public Student(String sname, String gender, String city) {
        this.sname = sname;
        this.gender = gender;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", gender='" + gender + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
