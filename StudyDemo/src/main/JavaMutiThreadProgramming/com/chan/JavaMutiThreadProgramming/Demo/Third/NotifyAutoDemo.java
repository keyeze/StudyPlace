package com.chan.JavaMutiThreadProgramming.Demo.Third;

/**
 * Created by Osborn on 2017/8/9.
 */
public class NotifyAutoDemo {

	public static void main(String[] args) {
		Object obj = new Object();
		new Thread(() -> {
			System.out.println("BEGIN ");
			try {
				synchronized (obj) {
					obj.wait(5000);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("END ");
		}).start();
	}
}
