package com.caleb.java.juc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:Caleb
 * @Date :2021-07-15 15:58:03
 * 
 *       实现一个容器，提供两个方法，add，size
 *       写两个线程，线程1添加10个元素到容器中，线程2实现监控元素的个数，当个数到5个时，线程2给出提示并结束.
 * 
 */
public class T2 {

	volatile List<Integer> list = new ArrayList<>();

	public void add(int i) {
		list.add(i);
	}

	public int getSize() {
		return list.size();
	}

	public static void main(String[] args) {

		T2 t2 = new T2();
		Object lock = new Object();

		new Thread(()->{
			synchronized(lock){
				System.out.println("t2 启动");
				if(t2.getSize() != 5){
					try {
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("t2 结束");
				}
				lock.notifyAll();
			}
		},"t2").start();


		// 线程1 添加10个元素
		new Thread(() -> {
			synchronized(lock){
				System.out.println("t1 启动");
				for(int i = 0;i<10;i++){
					t2.add(i+1);
					System.out.println("t1 增加" + (i+1));
					if(t2.getSize() == 5){
						lock.notify();
						try {
							lock.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				System.out.println("t1 结束");
			}
		}, "t1").start();
		;

	}

}