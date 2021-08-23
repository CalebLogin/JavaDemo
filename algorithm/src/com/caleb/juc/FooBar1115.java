package com.caleb.juc;

/**
 * @author:Caleb
 * @Date  :2021-08-23 23:48:21
 */
public class FooBar1115{



}

class FooBar {
    private int n;
	private Object o = new Object();
	private volatile boolean flag = true;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
			synchronized(o){
				if(!flag){
					o.wait();
				}
				printFoo.run();
				flag = false;
				o.notifyAll();
			}
        	// printFoo.run() outputs "foo". Do not change or remove this line.
        	
			
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
			
            synchronized(o){
				if(flag){
					o.wait();
				}
				printBar.run();
				flag = true;
				o.notifyAll();
			}
			
        }
    }
}