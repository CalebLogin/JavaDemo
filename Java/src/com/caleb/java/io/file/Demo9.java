package com.caleb.java.io.file;

import java.io.RandomAccessFile;

/**
 * @Date 2021/6/17 14:54
 * 使用RandomAccessFile读写文件
 */
public class Demo9 {
    public static void main(String[] args) throws Exception{
        //write();
        read();
    }
    //写入文件
    public static void write()throws Exception{
        //1创建RandomAccessFile对象
        RandomAccessFile raf=new RandomAccessFile("d:\\ran.txt", "rw");
        //2写入(内存中二进制数据形式直接写入硬盘)
        raf.writeUTF("张三");
        raf.writeInt(20);
        raf.writeBoolean(true);
        raf.writeDouble(180.5);

        raf.writeUTF("李四");
        raf.writeInt(22);
        raf.writeBoolean(false);
        raf.writeDouble(170.5);
        //3关闭
        raf.close();
        System.out.println("写入完毕");
    }
    //读取文件
    public static void read() throws Exception{
        //1创建RandomAccessFile对象
        RandomAccessFile raf=new RandomAccessFile("d:\\ran.txt","r" );
        //跳过张三的信息
        raf.skipBytes(21);
//        raf.skipBytes(21);
        //设置文件指针的偏移量
//        raf.seek(21);
//        raf.seek(21);
        //2读取
        String name = raf.readUTF();
        int age = raf.readInt();
        boolean sex = raf.readBoolean();
        double height = raf.readDouble();
        System.out.println(name+"..."+age+"..."+sex+"..."+height);
        //3关闭
        raf.close();
    }

}
