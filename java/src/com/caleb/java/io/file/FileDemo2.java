package com.caleb.java.io.file;

import java.io.File;

/**
 * @Date 2021/6/16 14:40
 * 练习1：遍历文件夹中所有的文件和子文件夹,包含子文件夹中的文件
 * 练习2：递归删除目录
 */
public class FileDemo2 {
    public static void main(String[] args) {
       // listDir(new File("d:\\aaa"),0);
        deleteDir(new File("d:\\aaa"));
    }
    //练习1：遍历文件夹中所有的文件和子文件夹,包含子文件夹中的文件
    public static void listDir(File dir,int level){
        File[] files = dir.listFiles();
        System.out.println(getSeprator(level)+dir.getAbsolutePath());
        level++;
        if(files!=null&&files.length>0){
            for (File file : files) {
                if(file.isDirectory()){
                    //递归
                    listDir(file,level);
                }else{
                    System.out.println(getSeprator(level)+file.getAbsolutePath());
                }
            }
        }
    }
    public static String getSeprator(int level){
        StringBuilder sb=new StringBuilder("|");
        for(int i=0;i<level;i++){
            sb.append("____");
        }
        return sb.toString();
    }
    //练习2：递归删除目录
    public static void deleteDir(File dir){
        File[] files = dir.listFiles();
        if(files!=null&&files.length>0){
            for (File file : files) {
                if(file.isDirectory()){
                    deleteDir(file);//递归
                }else{
                    System.out.println(file.toString()+"-----"+file.delete());;
                }
            }
        }
        //删除文件夹
        System.out.println(dir.toString()+"------"+dir.delete());
    }
}
