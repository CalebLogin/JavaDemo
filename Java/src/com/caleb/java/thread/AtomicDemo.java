package com.caleb.java.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Date 2021/6/16 11:08
 * i++是不是原子操作? 不是原子操作
 * 1 读取i的值
 * 2 执行加1操作
 * 3 写入i
 *  解决方法: (1)synchronized或Lock实现同步
 *            (2) 使用原子变量解决
 *
 */
public class AtomicDemo {
//  private int i;
    private AtomicInteger atomicInteger=new AtomicInteger(0);

    public int getValue(){
        return atomicInteger.getAndIncrement();//才有CAS无锁算法
    }
}
