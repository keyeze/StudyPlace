package com.ctchan.JavaMutiThreadProgramming.Demo;

/**
 * Created by Osborn on 2017/8/9.
 */
public class DeadLock_TwoStopDemo {
	public static class Service {

		synchronized public void methodA() {
			System.out.println("methodA begin");
			boolean isContinue = true;
			while (isContinue) {
			}
			System.out.println("methodA end");
		}

		synchronized public void methodB() {
			System.out.println("methodB begin");
			System.out.println("methodB end");
		}

	}

	public static void main(String[] args) {
		Service service = new Service();
		new Thread(service::methodA).start();
		new Thread(service::methodB).start();
	}
}
