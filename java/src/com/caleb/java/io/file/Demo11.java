package com.caleb.java.io.file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

/**
 * @Date 2021/6/17 15:52
 * Properties集合的使用
 */
public class Demo11 {
    public static void main(String[] args) throws Exception{
        //创建集合
        Properties properties=new Properties();
        properties.setProperty("username","张三" );
        properties.setProperty("password", "123");
        properties.setProperty("sex","男" );
        properties.setProperty("address", "北京");
        //与流有关的方法
        //list：列表打印输出
        properties.list(System.out);
        //store: 保存到properties文件
        FileOutputStream fos=new FileOutputStream("d:\\user.properties");
        properties.store(fos,"用户信息" );
        fos.close();
        //load: 加载属性文件
        System.out.println("---------load: 加载属性文件-------");
        Properties properties2=new Properties();
        FileInputStream fis=new FileInputStream("d:\\user.properties");
        properties2.load(fis);
        fis.close();
        properties2.list(System.out);
        System.out.println("-----------------获取系统的属性信息----------------------");
        Properties properties3 = System.getProperties();
        properties3.list(System.out);
    }
}
