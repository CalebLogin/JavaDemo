package com.eric.juc;

/**
 * @author：hanzhigang
 * @Date : 2021/2/25 1:37 PM
 */

class Clerk{

    private int products = 0;

    public synchronized void produceProducts(){
        if(products < 20){
            products++;
            System.out.println(Thread.currentThread().getName()+": 开始生产第"+products+"个产品");
            notify();
        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    public synchronized void consumeProducts(){
        if(products >0){
            System.out.println(Thread.currentThread().getName()+": 开始消费第"+products+"个产品");
            products--;
            notify();
        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}

class Producer extends Thread{

    Clerk clerk = null;

    Producer(Clerk clerk){
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println("开始生产产品...");
        while (true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.produceProducts();
        }

    }
}

class Consumer extends Thread{

    Clerk clerk = null;

    Consumer(Clerk clerk){
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println("开始消费产品...");
        while(true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.consumeProducts();
        }

    }
}


public class ProducerAndConsumerExample {

    public static void main(String[] args) {
        Clerk clerk = new Clerk();

        Producer producer = new Producer(clerk);
        Consumer consumer = new Consumer(clerk);

        producer.setName("生产者");
        consumer.setName("消费者");

        producer.start();
        consumer.start();


    }
}
