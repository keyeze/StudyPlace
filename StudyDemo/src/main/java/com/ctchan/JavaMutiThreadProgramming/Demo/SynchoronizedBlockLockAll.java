package com.ctchan.JavaMutiThreadProgramming.Demo;

/**
 * Created by Osborn on 2017/8/9.
 */
public class SynchoronizedBlockLockAll {
	public static class MyObject {
		synchronized public void speedPrintString() {
			System.out.println(
				"speedPrintString ____getLock time = " + System.currentTimeMillis() + " run ThreadName = " + Thread.currentThread()
					.getName());
			System.out.println("------------------------------");
			System.out.println(
				"speedPrintString releasseLock time = " + System.currentTimeMillis() + " run ThreadName = " + Thread.currentThread()
					.getName());
		}

		public void speedPrintString2() {
			synchronized (this) {
				System.out.println(
					"speedPrintString ____getLock time = " + System.currentTimeMillis() + " run ThreadName = " + Thread
						.currentThread()
						.getName());
				System.out.println("------------------------------");
				System.out.println(
					"speedPrintString releasseLock time = " + System.currentTimeMillis() + " run ThreadName = " + Thread
						.currentThread()
						.getName());
			}
		}
	}


	public static class Service {
		public void testModel1(MyObject obj) {
			synchronized (obj) {
				try {
					System.out.println(
						"testMethod1 ____getLock time = " + System.currentTimeMillis() + " run ThreadName=" + Thread.currentThread()
							.getName());
					Thread.sleep(2000);
					Thread.sleep(3000);
					System.out.println(
						"testMethod1 releaseLock time = " + System.currentTimeMillis() + " run ThreadName = " + Thread
							.currentThread().getName());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public static void main(String[] args) throws InterruptedException {
		Service service = new Service();
		MyObject obj = new MyObject();
		new Thread(() -> service.testModel1(
			obj
			//			new MyObject()
		), "A").start();
		Thread.sleep(100);
		new Thread(
			obj::speedPrintString2
//			obj::speedPrintString
			//			() ->
			//			service.testModel1(
			////			obj
			//			new MyObject()
			//		)
			, "B").start();

	}
}
