package com.caleb.java.desginmode.factory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @Date 2021/6/19 15:54
 * 服装厂类:负责具体产品的创建
 */
public class ClothesFactory {
    private static Properties properties;
    static {
        //初始化集合
        properties=new Properties();
        //加载配置文件
        try {
            FileInputStream fis=new FileInputStream("src\\clothes.properties");
            properties.load(fis);
            fis.close();
        } catch (IOException e) {
            System.out.println("加载配置文件失败");
        }
    }
    public static Clothes createClothes(int type){ //1 裤子 2 T恤 3 夹克
        Clothes clothes=null;
        if(properties.containsKey(Integer.toString(type))){
            String className = properties.getProperty(Integer.toString(type));
            try {
                Class<?> class1 = Class.forName(className);
                clothes=(Clothes) class1.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(clothes!=null){
            clothes.prepare();
            clothes.make();
            clothes.box();
        }
        return clothes;
    }
}
