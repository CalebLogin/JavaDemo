package com.caleb.java.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author:Caleb
 * @Date :2021-07-15 16:09:25
 */
public class T3 {

	volatile List<Integer> list = new ArrayList<>();

	public void add(int i) {
		list.add(i);
	}

	public int getSize() {
		return list.size();
	}

	public static void main(String[] args) {

		T3 t3 = new T3();
		CountDownLatch countDownLatch = new CountDownLatch(1);

		new Thread(() -> {
			System.out.println("t2 启动");
			if(t3.getSize()!=5){
				try {
					countDownLatch.await();
					System.out.println("t2 结束");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}, "t2").start();

		new Thread(() -> {
			System.out.println("t1 启动");
			for(int i = 0;i<10;i++){
				t3.add(i+1);
				if(t3.getSize() == 5){
					System.out.println("CountDown is open");
					countDownLatch.countDown();
				}
			}
			System.out.println("t1 结束");
		}, "t1").start();

	}

}