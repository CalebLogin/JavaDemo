package com.caleb.java.io.reflect;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

/**
 * @Date 2021/6/19 14:52
 */
public class TestStudent {
    public static void main(String[] args) throws Exception{
        Class<?> class1 = Class.forName("com.qf.day24_4.Student");
        Student s1 =(Student) class1.newInstance();
//        //获取setName方法
//        Method setName = class1.getMethod("setName",String.class);
//        setName.invoke(s1,"张三");
//        //获取setAge方法
//        Method setAge = class1.getMethod("setAge", int.class);
//        setAge.invoke(s1,20);

        //name age
        //创建属性描述符类:代表某个属性
        PropertyDescriptor dp1=new PropertyDescriptor("name", class1);
        Method setName = dp1.getWriteMethod();
        Object name="张三";
        setName.invoke(s1,name);

        PropertyDescriptor dp2=new PropertyDescriptor("age",class1 );
        Method setAge = dp2.getWriteMethod();
        Object age=20;
        setAge.invoke(s1,age);

        System.out.println(s1.toString());

        System.out.println("--------------获取Student类的属性--------------------");
        //如果类中有getXxx（无参有返回值）、setXxx(有参无返回值)、isXxx(无参有返回值，类型是boolean)，认为类种有这样的属性。
        //获取类的信息
        BeanInfo beanInfo = Introspector.getBeanInfo(class1);
        //获取属性
        PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor pd : pds) {
            System.out.println(pd.getName());
        }
    }
}
