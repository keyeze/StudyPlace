package com.ctchan.JavaMutiThreadProgramming.Demo;

/**
 * Created by Osborn on 2017/8/9.
 */

public class SynBlockString2 {
	public static class Service {
		private String anyString = new String();

		public void a() {
			try {
				synchronized (anyString) {
					System.out.println("a begin");
					Thread.sleep(3000);
					System.out.println("a end");
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		public synchronized void b() {
			System.out.println("b begin");
			System.out.println("b end");
		}
	}

	public static void main(String[] args) {
		Service service = new Service();
		new Thread(() -> service.a(), "a").start();
		new Thread(() -> service.b(), "b").start();

	}
}
