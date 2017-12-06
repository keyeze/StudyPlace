package com.chan.JavaMutiThreadProgramming.Demo.Third;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Osborn on 2017/8/9.
 */
public class TwoThreadTransData {
	public static class MyList {
		private List list = new ArrayList<>();

		public void add() {
			list.add("CtChan");
		}

		public int size() {
			return list.size();
		}
	}

	public static void main(String[] args) {
		MyList list = new MyList();
		new Thread(() -> {
			try {

				while (true) {
/*					synchronized ("") {
					}*/
					if (list.size() == 5) {
						System.out.println("==5了,线程B要退出了!");
						throw new InterruptedException();
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, "B").start();
		new Thread(() -> {
			try {
				for (int i = 0; i < 10; i++) {
					list.add();

					System.out.println("添加了" + (i + 1) + "个元素");
					Thread.sleep(1000);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, "A").start();
	}
}
