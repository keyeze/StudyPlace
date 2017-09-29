package com.chan.JavaMutiThreadProgramming.Demo.Third;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Osborn on 2017/8/9.
 */
public class TwoThreadTransDataByW_N {
	public static class MyList {
		private List list = new ArrayList<>();

		public void add() {
			list.add("CtChan");
		}

		public int size() {
			return list.size();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		MyList list = new MyList();

/*		new Thread(() -> {
			try {
				synchronized (list) {
					list.wait();
				}
				System.out.println("==5了,线程B要退出了!");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, "B").start();
		new Thread(() -> {
			try {
				for (int i = 0; i < 10; i++) {
					list.add();
					if (i == 5)
						synchronized (list) {
							list.notify();
						}
					System.out.println("添加了" + (i + 1) + "个元素");
					Thread.sleep(1000);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, "A").start();*/

		Object lock = new Object();

		Thread a = new Thread(() -> {
			try {
				synchronized (lock) {
					if (list.size() != 5) {
						System.out.println("wait begin " + System.currentTimeMillis());
						lock.wait();
						System.out.println("wait end " + System.currentTimeMillis());
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, "C");
		a.start();
		new Thread(() -> {
			try {
				synchronized (lock) {
					for (int i = 0; i < 10; i++) {
						list.add();
						if (list.size() == 5) {
							lock.notify();
							System.out.println("已发出通知!");
						}
						System.out.println("添加了" + (i + 1) + "个元素");
						Thread.sleep(1000);
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, "D").start();
	}
}
