package com.caleb.demo;

/**
 * @author：hanzhigang
 * @Date : 2021/1/13 7:52 PM
 */
public class equalstest {
    public static void main(String[] args) {
        String a = new String("ab");// a 为一个引用
        String b = new String("ab");// b 为另一个引用，对象的内容一样
        String aa = "ab"; // 放在常量池中
        String bb = "ab"; // 在常量池中找
        if(aa == bb){
            System.out.println("aa==bb");
        }
        if(a == b){
            System.out.println("a==b");
        }
        if(aa.equals(bb)){
            System.out.println("aaEQbb");
        }
        if(a.equals(b)){
            System.out.println("aEQb");
        }
    }
}
