package com.caleb.java.desginmode.singleton.student;

/**
 * @Date 2021/6/21 9:45
 */
public class TestStudent {
    public static void main(String[] args) {
        Student s1=new Student("树桐", 18, Gender.MALE);
        System.out.println(s1.toString());

    }
}
