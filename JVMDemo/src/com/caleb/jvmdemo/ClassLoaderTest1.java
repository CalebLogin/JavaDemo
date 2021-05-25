package com.caleb.jvmdemo;

import java.net.URL;
import java.security.Provider;

/**
 * 进一步了解启动类加载器和应用程序类加载器
 * @author：hanzhigang
 * @Date : 2021/3/1 9:41 PM
 */
public class ClassLoaderTest1 {

    public static void main(String[] args) {
        System.out.println("************启动类加载器*************");
//      获取bootstrapClassLoader能够加载的api路径
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for(URL element:urls){
            System.out.println(element.toExternalForm());
        }
        
//      测试jdk1.8.0_201.jdk/Contents/Home/jre/lib/jsse.jar下的provider.class
        ClassLoader providerClassLoader = Provider.class.getClassLoader();
        System.out.println(providerClassLoader);//启动类加载器

        System.out.println("************启动类加载器*************");
//      获取ExtensionClassLoader能够加载的api路径
        String extDirs = System.getProperty("java.ext.dirs");
        for(String path:extDirs.split(":")){
            System.out.println(path);
        }


    }

}
