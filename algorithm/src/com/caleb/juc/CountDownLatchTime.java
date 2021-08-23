package com.caleb.juc;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTime {

	public static void main(String[] args) {
		CountDownLatch c = new CountDownLatch(2);
		Thread t1 = new Thread(() -> {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				c.countDown();
			}
		}, "t1");

		Thread t2 = new Thread(() -> {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				c.countDown();
			}
		}, "t2");
		long startTimeM = System.currentTimeMillis();
		t1.start();
		t2.start();
		try {
			c.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long endTimeM = System.currentTimeMillis();
		System.out.println(endTimeM - startTimeM);
	}
}
