package com.caleb.demo;

/**
 * @author：hanzhigang
 * @Date : 2021/1/23 8:48 PM
 */
public class TargetObject {
    private String value;

    public TargetObject(){
        this.value = "JavaGuide";
    }

    public void publicMethod(String s) {
        System.out.println("I love " + s);
    }

    private void privateMethod() {
        System.out.println("value is " + value);
    }

}
