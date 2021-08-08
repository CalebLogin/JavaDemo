package com.caleb.algorithm.review.juc;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @author:Caleb
 * @Date :2021-07-23 09:13:53
 */
public class ZeroEvenOddExample {

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
			// 偶数
			if ((i & 1) == 0) {
				s2.release();
			} else {
				s3.acquire();
			}
		}
	}

	public void even(IntConsumer printNumber) throws InterruptedException {
		for (int i = 2; i <= n; i += 2) {
			s2.acquire();
			printNumber.accept(i);
			s1.release();
		}
	}

	public void odd(IntConsumer printNumber) throws InterruptedException {
		for (int i = 1; i <= n; i += 2) {
			s3.acquire();
			printNumber.accept(i);
			s1.release();
		}
    }
}