package com.chan.JavaMutiThreadProgramming.Demo;

/**
 * Created by Osborn on 2017/7/19.
 */
public class MyThread extends Thread{
	@Override
	public void run() {
		System.out.println("run is Ailve ? " + this.isAlive());

	}
}
