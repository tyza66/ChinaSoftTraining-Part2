package com.icss.pojo;

/**
 * 学生类
 * spring.xml文件 配置学生对象并对属性赋值
 */
public class Student {
    private String stuName;
    private double score;
    private Dog dog ;

    public void initStu(){
        System.out.println("初始化方法");
    }

    public void desStu(){
        System.out.println("销毁方法");
    }

    public Student() {
        System.out.println("Student无参数构造方法");
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

   /* @Override
    public String toString() {
        return "Student{" +
                "stuName='" + stuName + '\'' +
                ", score=" + score +
                ", dog=" + dog +
                '}';
    }*/
}
