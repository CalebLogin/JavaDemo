package com.caleb.algorithm;

/**
 * @author：hanzhigang
 * @Date : 2021/3/28 12:18 PM
 */
public class test {
    public static void main(String[] args) {
        father f = new father();
        System.out.println(f instanceof son);
    }
}
class father{
    public void m1(){
        System.out.println("father m1");
    }
}
class son extends father{
    public void m1(){
        System.out.println("son m1");
    }
    public void m2(){
        System.out.println("son m2");
    }
}
