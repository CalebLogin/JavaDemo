package com.caleb.java.io.file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * @Date 2021/6/17 9:22
 * 序列化：把对象写入到硬盘或网络中的过程。
 * 反序列化：把硬盘或网络的二进制文件读取到内存形成对象的过程。
 *
 * 注意事项:
 * (1)序列化类及其对象属性必须实现Serializable接口
 *（2）transient修饰为临时属性不参与序列化，static属性不参与序列化。
 * (3)使用serialVersionUID属性保证序列化的类和反序列化的类是同一个类。
 */
public class Demo1 {
    public static void main(String[] args) throws Exception{
        //serialize();
        deserialize();
    }
    //序列化(输出)
    public static void serialize() throws Exception{
        Student s1=new Student("树桐1", 20, "男",new Address("中国", "北京") );
        Student s2=new Student("树桐2", 20, "男",new Address("中国", "北京") );
        Student s3=new Student("树桐3", 20, "男",new Address("中国", "北京") );
        ArrayList<Student> list=new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);

        Student.studentCount=1000;
        //1 创建对象输出流
        FileOutputStream fos=new FileOutputStream("d:\\students.bin");
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        //2输出
        oos.writeObject(list);
        //3关闭(自动flush)
        oos.close();
        System.out.println("序列化完成...");
    }
    //反序列化(输入)
    public static void deserialize() throws Exception{
        //1创建对象输入流
        FileInputStream fis=new FileInputStream("d:\\students.bin");
        ObjectInputStream ois=new ObjectInputStream(fis);
        //2读取
//        Student s1=(Student) ois.readObject();
//        Student s2=(Student) ois.readObject();
//        Student s3=(Student) ois.readObject();
       // Student s4=(Student) ois.readObject();
        ArrayList<Student> list = ( ArrayList<Student>)ois.readObject();
        //3关闭
        ois.close();
//        System.out.println(s1.toString());
//        System.out.println(s2.toString());
//        System.out.println(s3.toString());
       // System.out.println(s4.toString());
        System.out.println(list.toString());
        System.out.println(Student.studentCount);
    }
}
