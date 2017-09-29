package com.chan.JavaMutiThreadProgramming.Demo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Osborn on 2017/8/9.
 */
public class ReadUnCommitDemo {
	public static class MyList {
		private List list = new ArrayList<>();

		synchronized public void add(String data) {
			System.out.println("ThreadName >> " + Thread.currentThread().getName() + " execute add() method !");
			list.add(data);
			System.out.println("ThreadName >> " + Thread.currentThread().getName() + " exit add() method!");
		}

		synchronized public int getSize() {
			System.out.println("ThreadName >> " + Thread.currentThread().getName() + " execute getSize() method!");
			int sizeValue = list.size();
			System.out.println("ThreadName >> " + Thread.currentThread().getName() + " exit getSize() method!");
			return sizeValue;

		}

	}


	public static class MyService {
		public MyList addServiceMethod(MyList list, String data) {
			synchronized (list) {
				//c1:移动到这个里面
			}
			try {//c1
				if (list.getSize() < 1) {
					Thread.sleep(2000);
					list.add(data);
				}

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return list;

		}
	}

	public static void main(String[] args) throws InterruptedException {
		MyList myList = new MyList();
		//		new Thread(() -> {
		//			for (int i = 0; i < 1000; i++) {
		//				myList.add("threadA" + (i + 1));
		//			}
		//		}, "A").start();
		//		new Thread(() -> {
		//			for (int i = 0; i < 1000; i++) {
		//				myList.add("threadB" + (i + 1));
		//			}
		//		}, "B").start();
		new Thread(() -> new MyService().addServiceMethod(myList, "A"), "A").start();
		new Thread(() -> new MyService().addServiceMethod(myList, "B"), "B").start();
		Thread.sleep(6000);
		System.out.println("listSize=" + myList.getSize());
	}
}
