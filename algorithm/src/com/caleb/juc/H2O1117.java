package com.caleb.juc;

import java.util.concurrent.*;

/**
 * @author:Caleb
 * @Date :2021-08-24 09:34:34
 */
public class H2O1117 {

}

class H2O {

	public H2O() {

	}

	private CyclicBarrier c1 = new CyclicBarrier(2);

	private Semaphore s1 = new Semaphore(2);

	private Semaphore s2 = new Semaphore(0);

	public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
		s1.acquire();
		try {
			c1.await();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		releaseHydrogen.run();
		if (c1.isBroken()) {
			s2.release();
		}
		// releaseHydrogen.run() outputs "H". Do not change or remove this line.

	}

	public void oxygen(Runnable releaseOxygen) throws InterruptedException {
		s2.acquire();
		releaseOxygen.run();
		c1.reset();
		s1.release(2);
		// releaseOxygen.run() outputs "O". Do not change or remove this line.

	}
}