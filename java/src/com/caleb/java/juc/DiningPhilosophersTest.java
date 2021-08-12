package com.caleb.java.juc;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 考察死锁的问题
 * 死锁产生的4个必要条件
 * 1）互斥条件：一个资源每次只能被一个进程使用
 * 2）占有且等待：一个进程已经占用了至少一个资源，同时请求新资源被阻塞时，对已获得的资源保持不放
 * 3）不可强行占有：进程已获得资源，在未使用完之前，不可强行剥夺
 * 4）循环等待条件：若干进程之间形成了一种头尾相接的循环等待资源条件
 *
 * @author：hanzhigang
 * @Date : 2021/2/28 11:32 PM
 */
public class DiningPhilosophersTest {
}

class DiningPhilosophers {

//  叉子锁
    ReentrantLock[] reentrantLock = new ReentrantLock[5];

//  一个一个串行吃
    ReentrantLock reentrantLock4 = new ReentrantLock();

//  限制最多4个人拿起叉子
    Semaphore semaphore = new Semaphore(4);
    public DiningPhilosophers() {
        for(int i = 0; i<reentrantLock.length;i++){
            reentrantLock[i] = new ReentrantLock();
        }
    }

    // call the run() method of any runnable to execute its code

    /**
     * 思路1，打破循环等待条件，哲学家先拿编号小的叉子,这种思路可能产生死锁
     * @param philosopher
     * @param pickLeftFork
     * @param pickRightFork
     * @param eat
     * @param putLeftFork
     * @param putRightFork
     * @throws InterruptedException
     */
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {

        int forks1 = philosopher;
        int forks2 = (philosopher+1)%5;

        reentrantLock[Math.min(forks1,forks2)].lock();
        reentrantLock[Math.max(forks1,forks2)].lock();
        pickLeftFork.run();
        pickRightFork.run();
        eat.run();
        putLeftFork.run();
        putRightFork.run();
        reentrantLock[Math.min(forks1,forks2)].unlock();
        reentrantLock[Math.max(forks1,forks2)].unlock();

    }

    /**
     * 思路2，奇数哲学家先拿起左边的叉子，再拿起右边的叉子，偶数哲学家先拿起右边的叉子，再拿起左边的叉子
     * @param philosopher
     * @param pickLeftFork
     * @param pickRightFork
     * @param eat
     * @param putLeftFork
     * @param putRightFork
     * @throws InterruptedException
     */
    public void wantsToEat1(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {

        int left = philosopher;
        int right = (philosopher+1)%5;
        if(philosopher % 2 == 0){
            reentrantLock[right].lock();
            reentrantLock[left].lock();
        }else{
            reentrantLock[left].lock();
            reentrantLock[right].lock();
        }

        pickLeftFork.run();
        pickRightFork.run();
        eat.run();
        putLeftFork.run();
        putRightFork.run();
        if(philosopher % 2 == 0){
            reentrantLock[right].unlock();
            reentrantLock[left].unlock();
        }else{
            reentrantLock[left].unlock();
            reentrantLock[right].unlock();
        }

    }

    /**
     * 思路2，保证最多只有4个哲学家同时持有叉子，这样保证最少1个哲学家能够吃到面条
     * @param philosopher
     * @param pickLeftFork
     * @param pickRightFork
     * @param eat
     * @param putLeftFork
     * @param putRightFork
     * @throws InterruptedException
     */
    public void wantsToEat2(int philosopher,
                            Runnable pickLeftFork,
                            Runnable pickRightFork,
                            Runnable eat,
                            Runnable putLeftFork,
                            Runnable putRightFork) throws InterruptedException {

        int left = philosopher;
        int right = (philosopher+1)%5;

//      就餐人数加一
        semaphore.acquire();
//      拿起叉子
        reentrantLock[left].lock();
        reentrantLock[right].lock();

        pickLeftFork.run();
        pickRightFork.run();
        eat.run();
        putLeftFork.run();
        putRightFork.run();

//      放下叉子
        reentrantLock[left].unlock();
        reentrantLock[right].unlock();

//      就餐人数减一
        semaphore.release();

    }

    /**
     * 思路4，一个一个串行吃
     * @param philosopher
     * @param pickLeftFork
     * @param pickRightFork
     * @param eat
     * @param putLeftFork
     * @param putRightFork
     * @throws InterruptedException
     */
    public void wantsToEat3(int philosopher,
                            Runnable pickLeftFork,
                            Runnable pickRightFork,
                            Runnable eat,
                            Runnable putLeftFork,
                            Runnable putRightFork) throws InterruptedException {

        int left = philosopher;
        int right = (philosopher+1)%5;

//      拿起叉子
        reentrantLock4.lock();

        pickLeftFork.run();
        pickRightFork.run();
        eat.run();
        putLeftFork.run();
        putRightFork.run();


//      放下叉子
        reentrantLock4.unlock();

    }

}
