package com.caleblogin;

import net.sf.cglib.proxy.Enhancer;

/**
 * @author:Caleb
 * @Date :2021-08-09 14:35:40
 */
public class CglibProxyFactory {

	public static Object getProxy(Class<?> clazz) {
		Enhancer enhancer = new Enhancer();
		enhancer.setClassLoader(clazz.getClassLoader());
		enhancer.setSuperclass(clazz);
		enhancer.setCallback(new DebugMethodInterceptor());
		return enhancer.create();
	}

}