package com.sdm.pojo;

/**
 * Author: tyza66
 * Date: 2023/6/20 10:12
 * Github: https://github.com/tyza66
 **/

public class Student {
    private String stuName;
    private double score;
    private Dog dog;

    public Student() {
    }

    public Student(String stuName, double score, Dog dog) {
        this.stuName = stuName;
        this.score = score;
        this.dog = dog;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuName='" + stuName + '\'' +
                ", score=" + score +
                ", dog=" + dog +
                '}';
    }

    public void init(){
        System.out.println("这是Student的初始化方法");
    }

    public void destroy(){
        System.out.println("这是Student的销毁方法");
    }
}
