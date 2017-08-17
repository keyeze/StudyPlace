package com.ctchan.JavaMutiThreadProgramming.Demo;

/**
 * Created by Osborn on 2017/7/19.
 */
public class WhyDemo {

	public static class Task implements Runnable {
		public static boolean flag = true;
		private long beginTime = System.currentTimeMillis();

		@Override
		public void run() {
			int i = 0;
			while (flag) {
				i++;
				System.out.println(i);
			}
			System.out.println("运行时间" + (System.currentTimeMillis() - beginTime) + " i = " + i);
			Thread.currentThread().notify();

		}
	}


	public static class Task2 implements Runnable {
		public static boolean flag = true;
		private long beginTime = System.currentTimeMillis();

		@Override
		public void run() {
			int i = 0;
			while (flag) {
				i++;
//				synchronized (this){}
			}
			System.out.println("运行时间" + (System.currentTimeMillis() - beginTime) + " i = " + i);
		}
	}

	public static void main(String[] args) throws InterruptedException {
		//		new Thread(new WhyDemo.Task()).start();
		//		Thread.sleep(300);
		//		WhyDemo.Task.flag = false;
		new Thread(new WhyDemo.Task2()).start();
		Thread.sleep(300);
		WhyDemo.Task2.flag = false;

	}

}

