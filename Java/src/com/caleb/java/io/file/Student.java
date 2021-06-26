package com.caleb.java.io.file;

import java.io.Serializable;

/**
 * @Date 2021/6/17 9:20
 */
public class Student implements Serializable {
    private String name;
    private transient int age;
    private String sex;
    private transient Address address;//transient 瞬间的，瞬时的
    public static int studentCount;
    //属性
    private static final long serialVersionUID=600L;

    public Student(String name, int age, String sex, Address address) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.address = address;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
