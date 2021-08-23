package com.caleb.juc;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @author:Caleb
 * @Date :2021-08-24 00:03:19
 */
public class ZeroEvenOdd1116 {

}

class ZeroEvenOdd {
	private int n;
	private Semaphore s1 = new Semaphore(1);
	private Semaphore s2 = new Semaphore(0);
	private Semaphore s3 = new Semaphore(0);

	public ZeroEvenOdd(int n) {
		this.n = n;
	}

	// printNumber.accept(x) outputs "x", where x is an integer.
	public void zero(IntConsumer printNumber) throws InterruptedException {
		for (int i = 1; i <= n; i++) {
			s1.acquire();
			printNumber.accept(0);
			if (i % 2 == 0) {
				s2.release();
			} else {
				s3.release();
			}
		}
	}

	public void even(IntConsumer printNumber) throws InterruptedException {
		for (int i = 1; i <= n; i++) {
			if (i % 2 == 0) {
				s2.acquire();
				printNumber.accept(i);
				s1.release();
			}

		}
	}

	public void odd(IntConsumer printNumber) throws InterruptedException {
		for (int i = 1; i <= n; i++) {
			if (i % 2 != 0) {
				s3.acquire();
				printNumber.accept(i);
				s1.release();
			}

		}
	}
}