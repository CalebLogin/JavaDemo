package com.caleb.algorithm.review.juc;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author:Caleb
 * @Date :2021-07-22 23:17:41
 * 
 *       按序打印
 * 
 *       我们提供了一个类：
 * 
 *       public class Foo {   public void first() { print("first"); }   public
 *       void second() { print("second"); }   public void third() {
 *       print("third"); } } 三个不同的线程 A、B、C 将会共用一个 Foo 实例。
 * 
 *       一个将会调用 first() 方法 一个将会调用 second() 方法 还有一个将会调用 third() 方法 请设计修改程序，以确保
 *       second() 方法在 first() 方法之后被执行，third() 方法在 second() 方法之后被执行
 */

class Foo {

	private ReentrantLock lock;
	private volatile boolean firstAvail = true;
	private volatile boolean secondAvail = false;
	private volatile boolean thirdAvail = false;

	public Foo() {
		lock = new ReentrantLock();

	}

	public void first(Runnable printFirst) throws InterruptedException {
		while (true) {
			if (firstAvail) {
				lock.lock();
				// printFirst.run() outputs "first". Do not change or remove this line.
				printFirst.run();
				firstAvail = false;
				secondAvail = true;
				lock.unlock();
				break;
			}

		}

	}

	public void second(Runnable printSecond) throws InterruptedException {
		while (true) {
			if (secondAvail) {
				lock.lock();
				// printSecond.run() outputs "second". Do not change or remove this line.
				printSecond.run();
				secondAvail = false;
				thirdAvail = true;
				lock.unlock();
				break;
			}

		}
	}

	public void third(Runnable printThird) throws InterruptedException {
		while (true) {
			if (thirdAvail) {
				lock.lock();
				// printThird.run() outputs "third". Do not change or remove this line.
				printThird.run();
				thirdAvail = false;
				firstAvail = true;
				lock.unlock();
				break;
			}

		}
	}
}

class Foo1 {

	private Semaphore s1 = new Semaphore(0);
	private Semaphore s2 = new Semaphore(0);

	public Foo1() {

	}

	public void first(Runnable printFirst) throws InterruptedException {

		// printFirst.run() outputs "first". Do not change or remove this line.
		printFirst.run();
		s1.release();

	}

	public void second(Runnable printSecond) throws InterruptedException {
		s1.acquire();
		// printSecond.run() outputs "second". Do not change or remove this line.
		printSecond.run();
		s2.release();

	}

	public void third(Runnable printThird) throws InterruptedException {
		s2.acquire();
		// printThird.run() outputs "third". Do not change or remove this line.
		printThird.run();

	}
}

class printFirst implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("first");
	}

}

public class FooExample {
	public static void main(String[] args) {
		Foo f = new Foo();
		Thread t1 = new Thread(() -> {
			try {
				f.first(() -> {
					System.out.println("first");
				});
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, "t1");
		Thread t2 = new Thread(() -> {
			try {
				f.second(() -> {
					System.out.println("second");
				});
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, "t2");
		Thread t3 = new Thread(() -> {
			try {
				f.third(() -> {
					System.out.println("third");
				});
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, "t3");
		t1.start();
		t2.start();
		t3.start();
	}
}