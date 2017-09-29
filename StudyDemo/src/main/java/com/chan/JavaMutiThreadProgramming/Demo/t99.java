package com.chan.JavaMutiThreadProgramming.Demo;

/**
 * Created by Osborn on 2017/8/9.
 */
public class t99 {
	public static class PrintString {
		public boolean isContinuePrint = true;

/*		public boolean isContinuePrint() {
			return isContinuePrint;
		}

		public PrintString setContinuePrint(boolean continuePrint) {
			isContinuePrint = continuePrint;
			return this;
		}*/

		public void printStringMethod() {
//			try {
				int i = 0;
				while (isContinuePrint) {
					i++;
//					System.out.println("run printStringMethod threadName = " + Thread.currentThread().getName());
//					Thread.sleep(1000);
				}
				System.out.println("已经结束！");
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		PrintString ps = new PrintString();
		//		ps.printStringMethod();
		new Thread(ps::printStringMethod).start();
		System.out.println("我要停止它!stopThread = " + Thread.currentThread().getName());
		Thread.sleep(300);
		ps.isContinuePrint = false;
	}
}
