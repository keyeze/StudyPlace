package com.chan.JavaMutiThreadProgramming.Demo;

/**
 * Created by Osborn on 2017/8/9.
 */
public class DeadLoclTest {
	public static class DealThread {
		public String username;
		public Object lock1 = new Object();
		public Object lock2 = new Object();

		public void setFlag(String username) {
			this.username = username;
		}

		public void run() {
			if (username.equals("CtChan")) {
				synchronized (lock1) {
					try {
						System.out.println("username = " + username);
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized (lock2) {
						System.out.println("按 lock1 -> lock2 代码顺序执行");
					}
				}
			}
			if (username.equals("nahCtC")) {
				synchronized (lock2) {
					try {
						System.out.println("username = " + username);
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized (lock1) {
						System.out.println("按 lock2 -> lock1 代码顺序执行");
					}
				}
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		DealThread dt = new DealThread();
		dt.setFlag("CtChan");
		new Thread(dt::run).start();
		Thread.sleep(100);
		dt.setFlag("nahCtC");
		new Thread(dt::run).start();
	}
}
