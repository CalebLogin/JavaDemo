package com.caleb.java.juc;

import java.util.Random;

/**
 * @author:Caleb
 * @Date :2021-07-15 19:15:21
 */
public class ThreadLocalStuTest implements Runnable {

	ThreadLocal<Student> stLocal = new ThreadLocal<>();

	@Override
	public void run() {
		String currentThreadName = Thread.currentThread().getName();
		System.out.println(currentThreadName + " is running...");
		Random random = new Random();
		int age = random.nextInt(100);
		System.out.println(currentThreadName + " is set age: " + age);
		Student student = getStudent();
		student.setAge(age);
		System.out.println(currentThreadName + " is first get age: " + student.getAge());
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(currentThreadName + " is second get age: " + student.getAge());

	}

	private Student getStudent() {
		Student student = stLocal.get();
		if (null == student) {
			student = new Student();
			stLocal.set(student);
		}
		return student;
	}

	public static void main(String[] args) {
		ThreadLocalStuTest t = new ThreadLocalStuTest();
		Thread t1 = new Thread(t,"threadA");
		Thread t2 = new Thread(t,"threadB");
		t1.start();
		t2.start();
	}

}

class Student {
	int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}