package com.ctchan.JavaMutiThreadProgramming.Demo;

/**
 * Created by Osborn on 2017/7/20.
 */
public class SuspendAndResumeDemo extends Thread {
	private long i = 0;

	public long getI() {
		return i;
	}
	public SuspendAndResumeDemo setI(long i) {
		this.i = i;
		return this;
	}
	@Override
	public void run() {
		try {
			while (true) {
				Thread.sleep(100);
				i++;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
