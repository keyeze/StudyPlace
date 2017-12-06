package com.chan.JavaMutiThreadProgramming.Demo.Second;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Osborn on 2017/8/9.
 */
public class AtomicIntergerNoSafe {
	public static class MyService {
		public static AtomicLong aiRef = new AtomicLong();

		public void addNum() {
			System.out.println(Thread.currentThread().getName() + "加了100之后的值是" + aiRef.addAndGet(100));
			aiRef.addAndGet(1);
		}
	}

	public static void main(String[] args) {
		try {
			MyService myService = new MyService();
			List<Thread> threads = new ArrayList<>(5);
			for (int i = 0; i < 5; i++) {
                threads.add(new Thread(myService::addNum));
            }
			threads.forEach(Thread::start);
			Thread.sleep(1000);
			System.out.println(MyService.aiRef.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
