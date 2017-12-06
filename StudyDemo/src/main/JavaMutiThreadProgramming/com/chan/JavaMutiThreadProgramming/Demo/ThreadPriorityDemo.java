package com.chan.JavaMutiThreadProgramming.Demo;

/**
 * Created by Osborn on 2017/7/20.
 */
public class ThreadPriorityDemo extends Thread {

	public static void main(String[] args) {
		System.out.println("main thread begin priority= " + Thread.currentThread().getPriority());
		Thread thread3 = new Thread(()-> System.out.println("thread3 run priority= " + Thread.currentThread().getPriority()));
		Thread.currentThread().setPriority(6);
		System.out.println("main.thread end priority= " + Thread.currentThread().getPriority());
		Thread thread1 = new Thread(() -> {
			System.out.println("thread1 run priority= " + Thread.currentThread().getPriority());
			Thread thread2 = new Thread(() -> System.out.println("thread2 run priority= " + Thread.currentThread().getPriority()));
			thread2.start();
		});
		thread1.start();
		thread3.start();

	}

}


