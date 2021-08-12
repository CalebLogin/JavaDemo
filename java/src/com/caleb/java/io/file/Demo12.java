package com.caleb.java.io.file;

import java.io.FileInputStream;

/**
 * @Date 2021/6/17 16:31
 */
public class Demo12 {
    public static void main(String[] args)throws Exception {
        FileInputStream fis=new FileInputStream("d:\\hello.txt");
        int d;
        while((d=fis.read())!=-1){
            System.out.print((char)d);
        }
        fis.close();
    }
}
