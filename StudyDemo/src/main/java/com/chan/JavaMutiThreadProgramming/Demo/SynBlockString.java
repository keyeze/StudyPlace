package com.chan.JavaMutiThreadProgramming.Demo;

/**
 * Created by Osborn on 2017/8/9.
 */

public class SynBlockString {
	public static class Service {
		protected String usernameParam;
		protected String passwordParam;
		protected String anyString = new String();

		public Service setUsernameAndPassword(String usernameParam, String passwordParam) {
			this.synMethod(usernameParam, passwordParam, this.anyString);
			return this;
		}

		public void synMethod(String usernameParam, String passwordParam, Object obj) {
			try {
				synchronized (obj) {
					System.out.println(
						"ThreadName >> " + Thread.currentThread().getName() + " over " + System.currentTimeMillis()
							+ " into synBlock ");
					this.usernameParam = usernameParam;
					Thread.sleep(3000);
					this.passwordParam = passwordParam;
					System.out.println("ThreadName >> " + Thread.currentThread().getName() + " over " + System.currentTimeMillis()
						+ " out synBlock");
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}


	public static class Service2 extends Service {
		@Override
		public Service setUsernameAndPassword(String usernameParam, String passwordParam) {
			synMethod(usernameParam, passwordParam, new String());
			return this;
		}

		public static Service newIntance(int i) {
			switch (i) {
			case 1:
				return new Service();
			case 2:
				return new Service2();
			}
			return null;
		}
	}

	public static void main(String[] args) {
		final Service service =
			new Service();
			new Service2();
		new Thread(() -> service.setUsernameAndPassword("aa", "aa"), "a").start();
		new Thread(() -> service.setUsernameAndPassword("bb", "bb"), "b").start();
		//实验于 2014-06-24 15:10:55
		//		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(1403593855098L)));
	}
}
