package com.caleb.java.juc;

/**
 * @author:Caleb
 * @Date :2021-07-15 19:04:08
 * 
 *       ThreadLocal 每个线程维护一个“序列号”
 * 
 */
public class SerialNum {

	private static int nextSerialNum = 0;
	private static ThreadLocal<Integer> serialNum = new ThreadLocal<>() {

		@Override
		protected Integer initialValue() {
			// TODO Auto-generated method stub
			return nextSerialNum++;
		}
	};

	public static int get(){
		return serialNum.get().intValue();
	}

	public static void main(String[] args) {
		for(int i = 0;i<10;i++){
			new Thread(()->{
				System.out.println(SerialNum.get());
			},"t1").start();
		}
	}

}