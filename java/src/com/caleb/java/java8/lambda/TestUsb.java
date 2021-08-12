package com.caleb.java.java8.lambda;

/**
 * @Date 2021/6/21 11:45
 */
public class TestUsb {
    public static void main(String[] args) {
        Usb usb=new Usb() {
            @Override
            public void service() {
                System.out.println("连接电脑成功，开始工作");
            }
        };
        usb.service();

        Usb usb2=()->{
            System.out.println("连接电脑成功，开始工作");
        };
        usb2.service();
    }
}
