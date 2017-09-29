package com.chan.JavaMutiThreadProgramming.Demo.Third;

/**
 * Created by Osborn on 2017/8/9.
 */
public class WaitTest {
	public static class Service {
		public void method(Object obj) throws InterruptedException {
			Thread.sleep(2000);
			System.out.println(Thread.currentThread().getName() + "进入等待");
			obj.wait();
			System.out.println(Thread.currentThread().getName() + "被唤醒");
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Object obj = new Object();
		Object obj2 = new Object();
		Service service = new Service();

		new Thread(() -> {
			try {
				Thread.sleep(1000);
				while (true) {
					synchronized (obj2) {
						service.method(obj2);
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, "A1").start();
		new Thread(() -> {
			try {
				Thread.sleep(1000);
				while (true) {
					synchronized (obj2) {
						service.method(obj2);
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, "A2").start();
		new Thread(() -> {
			try {
				Thread.sleep(1000);
				while (true) {
					synchronized (obj2) {
						service.method(obj2);
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, "A3").start();
		new Thread(() -> {
			try {
				Thread.sleep(1000);
				while (true) {
					Thread.sleep(4000);
					synchronized (obj2) {
						obj2.notifyAll();
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, "B").start();
	}
}
