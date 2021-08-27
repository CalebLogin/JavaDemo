package com.caleb.juc;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 * @author:Caleb
 * @Date  :2021-08-23 23:35:06
 */
public class Foo1114{

    private CyclicBarrier c1 = new CyclicBarrier(2);

}

class Foo {

	Semaphore s1 = new Semaphore(0);
	Semaphore s2 = new Semaphore(0);	

    public Foo() {
        
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