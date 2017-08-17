package com.ctchan.JavaMutiThreadProgramming.Demo;

/**
 * Created by Osborn on 2017/8/9.
 */
public class SynExString {
	public static class Service {
		public static void print(Object stringParam) {
			try {
				synchronized (stringParam) {
					while (true) {
						System.out.println(Thread.currentThread().getName());
						Thread.sleep(1000);
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new Thread(()->Service.print("HH"), "A").start();
		new Thread(()->Service.print("H"), "B").start();

	}


}
