package com.caleblogin;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * @author:Caleb
 * @Date  :2021-08-09 14:33:49
 */
public class DebugMethodInterceptor implements MethodInterceptor{

	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("before method" + method.getName());
		Object o = proxy.invokeSuper(obj, args);
		System.out.println("after method");
		return o;
	}



}