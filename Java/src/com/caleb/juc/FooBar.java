package com.caleb.juc;

/**
 * @author：hanzhigang
 * @Date : 2021/2/28 8:09 PM
 */
class FooBar {
    private int n;
    private byte[] bytes = new byte[0];
    private int count = 0;
    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        synchronized (bytes){
            for (int i = 0; i < n; i++) {
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                bytes.wait();
                bytes.notifyAll();
                count++;
            }
        }

    }

    public void bar(Runnable printBar) throws InterruptedException {
        synchronized (bytes){
            for (int i = 0; i < n; i++) {

                // printBar.run() outputs "bar". Do not change or remove this line.
                while (count != 1){
                    bytes.wait();
                }
                printBar.run();
                count--;
                bytes.notifyAll();
            }
        }

    }
}
