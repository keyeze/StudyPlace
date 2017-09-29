package com.chan.JavaMutiThreadProgramming.Demo;

/**
 * Created by Osborn on 2017/7/19.
 */
public class AsynchronizedAndSynchronizedDemo {
	public static class Task {
		public void doLongTimeTask() {
			for (int i = 0; i < 100; i++)
				System.out.println("Asynchronized threadName = " + Thread.currentThread().getName()+" i = " + i);
			System.out.println("");
			synchronized (this) {
				for (int i = 0; i < 100; i++)
					System.out.println("Synchronized threadName = " + Thread.currentThread().getName()+" i = " + i);
			}
		}
	}

	public static void main(String[] args) {
		Task task = new Task();
		new Thread(task::doLongTimeTask).start();
		new Thread(task::doLongTimeTask).start();


	}

}
