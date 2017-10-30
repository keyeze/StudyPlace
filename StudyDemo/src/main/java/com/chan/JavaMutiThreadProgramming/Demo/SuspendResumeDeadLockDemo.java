package com.chan.JavaMutiThreadProgramming.Demo;

/**
 * Created by Osborn on 2017/7/20.
 */
public class SuspendResumeDeadLockDemo extends Thread {
	public static class SynchronizedObject {
		synchronized public void printString() {
			System.out.println("begin");
			if ("a".equals(Thread.currentThread().getName())) {
				System.out.println("a 线程永远 suspend 了！");
				Thread.currentThread().suspend();
			}
			System.out.println("end");
		}
	}

	public static void main(String[] args) {
		try {
			final SuspendResumeDeadLockDemo.SynchronizedObject so = new SuspendResumeDeadLockDemo.SynchronizedObject();
			Thread thread = new Thread(so::printString);
			thread.setName("a");
			thread.start();
			Thread.sleep(1000);
			Thread thread2 = new Thread(() -> {
				System.out.println("thread2 启动了,但是进不了printString()方法！");
				System.out.println("因为printString()方法被a线程锁定并且永远suspend暂停了！");
				so.printString();
			});
			thread2.start();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}


