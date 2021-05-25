package com.eric.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author：hanzhigang
 * @Date : 2021/1/24 4:18 PM
 */
public class DebugInvocationHandler implements InvocationHandler {
    /**
     *代理类中真实的对象
     */
    private final Object target;

    public DebugInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before message " + method.getName());
        Object result = method.invoke(target,args);
        System.out.println("after send " + method.getName());
        return result;
    }
}
