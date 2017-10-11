package com.chan.JavaMutiThreadProgramming.Demo.Third;

import java.util.Date;

/**
 * Created by Osborn on 2017/8/9.
 */
public class Demo {
	public static void main(String[] args) throws InterruptedException {
		//		Thread a = new Thread(() -> {
		//			while (true) {
		//				Thread.interrupted();
		//			}
		//
		//		});
		//		a.start();
		//		Thread.sleep(5000);
		//		a.interrupt();
		//
		//		List list = new ArrayList();
		//		list.get(0);

		Date now = new Date();
		System.out.println(now);
		System.out.println(new Date(now.getTime() + 86400000L));
		Object a = (int) (86400000L * 10000 / 86400000L);
		System.out.println(a.getClass());

	}
}
