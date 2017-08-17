package com.ctchan.JavaMutiThreadProgramming.Demo;

/**
 * Created by Osborn on 2017/7/19.
 */
public class SynchronizedShorting {
	public static class Task {
		private String getDetail1;
		private String getDetail2;

		public synchronized void doLongTimeTask() {
			try {
				System.out.println("Begin task()");
				Thread.sleep(3000);
				getDetail1 = "长时间处理任务后从远程返回的值 1 threadName = " + Thread.currentThread().getName();
				getDetail2 = "长时间处理任务后从远程返回的值 2 ThreadName = " + Thread.currentThread().getName();
				System.out.println(getDetail1);
				System.out.println(getDetail2);
				System.out.println("end task");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}


	public static class CommonUtils {
		public static long beginTime1;
		public static long beginTime2;
		public static long endTime1;
		public static long endTime2;
	}


	public static class MyThread extends Thread {
		private SynchronizedShorting.Task task;

		public MyThread(SynchronizedShorting.Task task, Runnable runnable) {
			super(runnable);
			this.task = task;
		}
	}

	public static void main(String[] args) {
		SynchronizedShorting.Task task = new SynchronizedShorting.Task();
		new MyThread(task, () -> {
			CommonUtils.beginTime1 = System.currentTimeMillis();
			task.doLongTimeTask();
			CommonUtils.endTime1 = System.currentTimeMillis();
		}).start();
		new MyThread(task, () -> {
			CommonUtils.beginTime2 = System.currentTimeMillis();
			task.doLongTimeTask();
			CommonUtils.endTime2 = System.currentTimeMillis();
		}).start();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long beginTime = CommonUtils.beginTime2 < CommonUtils.beginTime1 ? CommonUtils.beginTime2 : CommonUtils.beginTime1;
		long endTime = CommonUtils.endTime2 > CommonUtils.endTime1 ? CommonUtils.endTime2 : CommonUtils.endTime1;
		System.out.println("两个线程完成任务总耗时为" + (endTime - beginTime));
	}
}
