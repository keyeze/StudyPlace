package com.chan.JavaMutiThreadProgramming.Demo;

/**
 * Created by Osborn on 2017/7/19.
 */
public class twoObjectTowLockDemo extends Thread {
	@Override
	public void run() {

	}
}


class HasSelfPrivateNum {
	private int num = 0;

	synchronized public void addI(String username) {
		try {
			if ("a".equals(username)) {
				num = 100;
				System.out.println("a set over!");
				Thread.sleep(2000);
			} else {
				num = 200;
				System.out.println("b set over!");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
