package com.caleb.java.desginmode.singleton.student;

/**
 * @Date 2021/6/21 9:37
 * 枚举的注意事项:
 * 1 枚举中主要包括静态常量(只写常量名),常量之间使用逗号隔开，最后分号可写可不写(如果后面有代码必须写)。
 * 2 枚举也可以包括私有构造方法，属性，方法，但是必须写在常量的后面。
 */
public enum Gender {
    MALE,FEMALE;
//    private Gender(){
//
//    }
//    private int value;
//
//    public void show(){
//        System.out.println(value);
//    }
}
