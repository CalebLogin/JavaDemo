package com.caleb.java.io.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Date 2021/6/19 10:30
 */
public class ReflectDemo {
    public static void main(String[] args)throws Exception {
        reflect5();
    }
    //反射操作1：获取类对象
    public static void reflect1()throws Exception{
        //获取类对象的三种方式
        //第一种方式: 创建类的对象获取
        Student s1=new Student("张三", 20);
        Class class1=s1.getClass();
        System.out.println(class1.hashCode());
        //第二种方式: 通过类名.class获取
        Class class2=Student.class;
        System.out.println(class2.hashCode());
        //第三种方式: 通过Class.forName(); 推荐：耦合性低，编译时不依赖目标类。
        Class class3=Class.forName("com.qf.day24_2.Student");
        System.out.println(class3.hashCode());
    }
    //反射操作2：获取类对象的基本信息
    public static void reflect2() throws Exception{
        Class class1=Class.forName("com.qf.day24_2.Student");
        System.out.println("类的全名称:"+class1.getName());
        System.out.println("类的简单名称:"+class1.getSimpleName());
        System.out.println("类的包名:"+class1.getPackage().getName());
        System.out.println("类的父类:"+class1.getSuperclass().getName());
        Class[] interfaces = class1.getInterfaces();
        for (Class inter : interfaces) {
            System.out.println(inter);
        }
    }
    //反射操作3：获取类的构造方法对象
    public static void reflect3() throws Exception{
        Class class1=Class.forName("com.qf.day24_2.Student");
        //1获取所有公开的构造方法
//        Constructor[] constructors = class1.getConstructors();
//        for (Constructor con : constructors) {
//            System.out.println(con.toString());
//        }
        //2获取无参构造方法
        Constructor con1=class1.getConstructor();
        Student s1=new Student();
        Student s2=(Student) con1.newInstance();
        System.out.println(s1.toString());
        System.out.println(s2.toString());
        //3获取带参构造方法
        Constructor con2 = class1.getConstructor(String.class, int.class);
        Student s3=new Student("张三", 20);
        Student s4 = (Student) con2.newInstance("李四", 22);
        System.out.println(s3.toString());
        System.out.println(s4.toString());
        //简写
        Student s5 = (Student) class1.newInstance();
        System.out.println(s5.toString());
    }
    //反射操作4：获取类的普通方法对象
    public static void reflect4() throws Exception{
        Class class1=Class.forName("com.qf.day24_2.Student");
        //1获取类的所有的公开的方法，包括继承的。
//        Method[] methods = class1.getMethods();
        //获取类的所有的方法，包括非公开的，不包括继承的。
//        Method[] methods = class1.getDeclaredMethods();
//        for (Method method : methods) {
//            System.out.println(method);
//        }
        //2 获取无参无返回值的方法
        Method methodShow=class1.getMethod("show");
        Student s1=(Student) class1.newInstance();
        s1.show();
        methodShow.invoke(s1);//s1.show();
        //3 获取带参方法
        Method methodShow2 = class1.getMethod("show", String.class);
        s1.show("上海");
        methodShow2.invoke(s1,"杭州");// s1.show("杭州")
        //3 获取带返回值方法
        Method getAddress = class1.getMethod("getAddress");
        String a=s1.getAddress();
        System.out.println(a);
        String a2=(String) getAddress.invoke(s1);
        System.out.println(a2);
        //4 获取私有方法
        Method study = class1.getDeclaredMethod("study");
        study.setAccessible(true);//访问权限无效
        study.invoke(s1);
        //5 获取静态方法
        Method exam = class1.getMethod("exam");
        Student.exam();
        exam.invoke(null);// Student.exam();
    }
    //反射操作5：获取类的属性对象
    public static void reflect5() throws Exception{
        Class class1=Class.forName("com.qf.day24_2.Student");
        //1获取所有的属性
//        Field[] fields = class1.getDeclaredFields();
//        for (Field field : fields) {
//            System.out.println(field);
//        }
        //2 获取name属性
        Student s1=(Student) class1.newInstance();
        Field name = class1.getDeclaredField("name");
        //s1.name="张三";
        name.setAccessible(true);//访问权限无效
        name.set(s1, "张三");// s1.name="张三";
        //3获取age属性
        Field age = class1.getDeclaredField("age");
        age.setAccessible(true);
        age.set(s1, 20);
        System.out.println(s1.toString());

    }

}
