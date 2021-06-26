package com.caleb.java.io.reflect;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * @Date 2021/6/19 14:24
 */
public class TestCarService {
    public static void main(String[] args) throws Exception {
        //读取cars.txt文件
        FileReader fr=new FileReader("src\\cars.txt");
        BufferedReader br=new BufferedReader(fr);
        String classname;
        while((classname=br.readLine())!=null){
            //System.out.println(classname);
            //Class.forName
            try {
                Class class1=Class.forName(classname);
                CarService carService = (CarService) class1.newInstance();
                carService.run();
                carService.turn("东");
            } catch (ClassNotFoundException e) {
                continue;
            }
        }
        br.close();
    }
}
