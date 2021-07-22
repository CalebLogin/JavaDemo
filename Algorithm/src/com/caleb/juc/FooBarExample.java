package com.caleb.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author:Caleb
 * @Date :2021-07-23 00:10:44
 */
public class FooBarExample {

}

class FooBar {
	private int n;
	private ReentrantLock reentrantLock = new ReentrantLock();
	private Condition c1 = reentrantLock.newCondition();
	volatile boolean flag = true;

	public FooBar(int n) {
		this.n = n;
	}

	public void foo(Runnable printFoo) throws InterruptedException {

		for (int i = 0; i < n; i++) {
			reentrantLock.lock();
			try {
				while (!flag) {

					c1.await();
				}
				printFoo.run();
				flag = false;
				c1.signalAll();
				// printFoo.run() outputs "foo". Do not change or remove this line.
				printFoo.run();
			} finally {
				reentrantLock.unlock();
			}

		}
	}

	public void bar(Runnable printBar) throws InterruptedException {

		for (int i = 0; i < n; i++) {
			reentrantLock.lock();
			try {
				while (flag) {
					c1.await();
				}
				// printBar.run() outputs "bar". Do not change or remove this line.
				printBar.run();
				flag = true;
				c1.signal();
			} finally {
				reentrantLock.unlock();
			}

		}
	}
}