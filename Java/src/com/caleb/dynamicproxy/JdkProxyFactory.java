package com.caleb.dynamicproxy;

import java.lang.reflect.Proxy;

/**
 * @author：hanzhigang
 * @Date : 2021/1/24 4:23 PM
 */

public class JdkProxyFactory {

    public static Object getProxy(Object target){
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(), //加载器
                target.getClass().getInterfaces(), //接口
                new DebugInvocationHandler(target) //代理对象对应的自定义 InvovationHandler
        );

    }

    public static void main(String[] args) {
        SmsService smsService = (SmsService) JdkProxyFactory.getProxy(new SmsServiceImpl());
        smsService.send("java");

    }
}
