package com.caleb.java.io.file;

import java.io.File;
import java.io.FileFilter;
import java.util.Date;

/**
 * @Date 2021/6/16 11:40
 * File类的使用
 * 1 文件操作
 * 1.1 创建文件
 * 1.2 删除文件
 * 1.3 获取信息
 * 1.4 判断
 * 1.5 重命名
 *
 * 2 文件夹操作
 * 2.1 创建文件夹
 * 2.2 删除文件夹
 * 2.3 获取信息
 * 2.4 判断
 * 2.5 重命名
 * 2.6 遍历文件夹中文件或子文件
 *
 */
public class FileDemo {
    public static void main(String[] args) throws Exception{
       // fileOperate();
        dirOperate();
    }
    //文件操作
    public static void fileOperate() throws Exception{
        //1 创建文件
        File file=new File("d:\\aaa.txt");//路径可以真实存在的路径，或不存在。
        System.out.println(file.toString());
        if(!file.exists()){
            //创建
            boolean b=file.createNewFile();
            System.out.println("创建的结果:"+b);
        }else{
            System.out.println("文件已存在");
        }
        //2删除文件
        //2.1 直接删除
//        boolean b2=file.delete();
//        System.out.println("删除结果:"+b2);
        //2.2 JVM删除
//        Thread.sleep(5000);
//        file.deleteOnExit();
        //3 获取信息
        System.out.println("长度:"+file.length());
        System.out.println("文件名:"+file.getName());
        System.out.println("路径:"+file.getPath());
        System.out.println("绝对路径:"+file.getAbsolutePath());
        System.out.println("最后一次修改时间:"+new Date(file.lastModified()));
        //4 判断
        System.out.println("是不是可写:"+file.canWrite());
        System.out.println("是不是文件:"+file.isFile());
        System.out.println("是不是隐藏:"+file.isHidden());
        //5 重命名(具有剪切的功能)
        boolean b3=file.renameTo(new File("d:\\myfile\\bbb.txt"));
        System.out.println("重命名:"+b3);
    }
    //文件夹操作
    public static void dirOperate(){
        //2.1 创建文件夹
        File dir=new File("d:\\aaa\\bbb\\ccc");
        System.out.println(dir.toString());
        if(!dir.exists()){
            boolean b=dir.mkdirs();
            System.out.println("创建结果:"+b);
        }else{
            System.out.println("文件夹已存在");
        }
        //2.2删除文件夹(删除最深层的目录，必须是空目录)
//        boolean b2=dir.delete();
//        System.out.println("删除结果:"+b2);
        //2.3获取信息
        System.out.println("文件夹名称:"+dir.getName());
        System.out.println("路径:"+dir.getPath());
        System.out.println("绝对路径:"+dir.getAbsolutePath());
        //2.4判断
        System.out.println("是不是目录:"+dir.isDirectory());
        System.out.println("是不是隐藏:"+dir.isHidden());
        //2.5重命名
        boolean b3=dir.renameTo(new File("d:\\aaa\\bbb\\haha"));
        System.out.println("重命名:"+b3);
        //2.6遍历文件中文件或子文件夹
//        System.out.println("---------------list---------------");
//        File dir2=new File("d:\\");
//        String[] list = dir2.list();
//        for (String s : list) {
//            System.out.println(s);
//        }
//        System.out.println("-----------listFiles-------------------");
//        File[] files = dir2.listFiles();
//        for (File file : files) {
//            System.out.println(file.getAbsolutePath());
//        }
        System.out.println("------------过滤符合要求的文件: .jpg文件------------------");
        File dir3=new File("d:\\图片\\");
        File[] files2=dir3.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if(pathname.isFile()&&pathname.getName().endsWith(".png")){
                    return true;
                }
                return false;//返回true 符合要求；返回false不符合要求
            }
        });
        for (File file : files2) {
            System.out.println(file);
        }

    }

}
