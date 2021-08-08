package com.caleb.main;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author:Caleb
 * @Date :2021-08-02 12:46:08
 */
public class Main9 {

	private static Lock lock = new ReentrantLock();

	private static Condition condition = lock.newCondition();

	public static void main(String[] args) {
		Runnable task = new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				lock.lock();
				try {
					condition.await(5, TimeUnit.MINUTES);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				lock.unlock();
			}

		};
		new Thread(task, "t1").start();
		new Thread(task, "t2").start();
	}

}