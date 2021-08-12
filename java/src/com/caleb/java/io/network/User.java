package com.caleb.java.io.network;

import java.io.Serializable;

/**
 * @Date 2021/6/18 15:53
 */
public class User implements Serializable {
    //序列化版本id
    private static final long serialVersionUID=1000L;
    //id
    private int id;
    //姓名
    private String name;
    //密码
    private String pwd;
    //年龄
    private int age;
    //成绩
    private double score;

    public User(int id, String name, String pwd, int age, double score) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
        this.age = age;
        this.score = score;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}
