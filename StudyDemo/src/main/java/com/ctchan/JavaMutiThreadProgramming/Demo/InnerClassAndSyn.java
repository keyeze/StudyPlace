package com.ctchan.JavaMutiThreadProgramming.Demo;

/**
 * Created by Osborn on 2017/8/9.
 */
public class InnerClassAndSyn {
	public class Inner {
		public void method1() {
			synchronized (InnerClassAndSyn.Inner.class) {
				for (int i = 0; i < 10; i++) {
					System.out.println(Thread.currentThread().getName() + " i = " + i);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
			}
		}

		public synchronized void method2() {
			for (int i = 11; i < 20; i++) {
				System.out.println(Thread.currentThread().getName() + " i = " + i);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}
	}

	public static void main(String[] args) {
		InnerClassAndSyn.Inner inner = new InnerClassAndSyn().new Inner();
		new Thread(inner::method1).start();
		new Thread(inner::method2).start();
	}
}
