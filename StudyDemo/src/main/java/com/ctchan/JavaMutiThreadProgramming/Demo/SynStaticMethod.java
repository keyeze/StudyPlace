package com.ctchan.JavaMutiThreadProgramming.Demo;

/**
 * Created by Osborn on 2017/8/9.
 */
public class SynStaticMethod {
	public static class Service {

		synchronized public static void printA() {
			try {
				System.out.println("ThreadName >> " + Thread.currentThread().getName() + " in " + System.currentTimeMillis()
					+ " into printA() method");
				Thread.sleep(3000);
				System.out.println("ThreadName >> " + Thread.currentThread().getName() + " in " + System.currentTimeMillis()
					+ " out printA() method");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		synchronized public static void printB() {
			System.out
				.println("ThreadName >> " + Thread.currentThread().getName() + " in " + System.currentTimeMillis()
					+ " into printB() method");
			System.out
				.println("ThreadName >> " + Thread.currentThread().getName() + " in " + System.currentTimeMillis()
					+ " out printB() method");
		}

		synchronized public void printC() {
			System.out
				.println("ThreadName >> " + Thread.currentThread().getName() + " in " + System.currentTimeMillis()
					+ " into printC() method");
			System.out
				.println("ThreadName >> " + Thread.currentThread().getName() + " in " + System.currentTimeMillis()
					+ " out printC() method");
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Service service = new Service();
		new Thread(()->service.printA(), "A").start();
		new Thread(Service::printB, "B").start();
		new Thread(service::printC, "C").start();

	}
}
