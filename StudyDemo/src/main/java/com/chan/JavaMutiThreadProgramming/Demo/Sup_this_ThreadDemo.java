package com.chan.JavaMutiThreadProgramming.Demo;

/**
 * Created by Osborn on 2017/7/19.
 */
public class Sup_this_ThreadDemo {
	public static class Main {
		protected int i = 10;

		synchronized public void say() {
			try {
				System.out.println("this is super !");
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		synchronized public void say2() {
			try {
				i--;
				System.out.println("main : i= " + i);
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}


	public static class Sub extends Sup_this_ThreadDemo.Main {
		synchronized public void say() {
			try {
				System.out.println("this is sub！");
				Thread.sleep(100);
				this.say();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		synchronized public void say2() {
			try {
				while (i > 0) {
					i--;
					System.out.println("sub : i= " + i);
					Thread.sleep(100);
					super.say();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new Thread(() -> new Sup_this_ThreadDemo.Sub().say2()).start();
	}

}

