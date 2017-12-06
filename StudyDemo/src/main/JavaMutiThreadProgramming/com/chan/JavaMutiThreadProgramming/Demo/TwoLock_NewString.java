package com.chan.JavaMutiThreadProgramming.Demo;

/**
 * Created by Osborn on 2017/8/9.
 */
public class TwoLock_NewString {
	public static class MyService {
		private String lock = "123";

		public void testMethod() {
			try {
				synchronized (lock) {
					System.out.println(Thread.currentThread().getName() + " begin " + System.currentTimeMillis());
//					Thread.sleep(100);
					lock = "456";
					Thread.sleep(2000);
					System.out.println(Thread.currentThread().getName() + " end " + System.currentTimeMillis());
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		MyService service = new MyService();
		new Thread(service::testMethod,"A").start();
		Thread.sleep(50);
		new Thread(service::testMethod,"B").start();
	}
}
