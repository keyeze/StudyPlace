import com.ctchan.JavaMutiThreadProgramming.Demo.MyThread;
import com.ctchan.JavaMutiThreadProgramming.Demo.StopThread;
import com.ctchan.JavaMutiThreadProgramming.Demo.SuspendAndResumeDemo;
import org.junit.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Osborn on 2017/7/18.
 */
public class test {
	public static final int NUM = 12;
	public static final String STR = "hahah";
	public static final Object OBJ = new Object() {
		@Override
		public String toString() {
			return "haha";
		}
	};

	@Test
	public void say() {
		System.out.println(NUM);
		System.out.println(STR);
		System.out.println(OBJ);

	}

	@Test
	public void fun() {

		Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0).filter(item -> item >= 5).collect(Collectors.toList());

	}

	@Test
	//测试：使用isAlive
	public void thread_isAlive_demo() throws InterruptedException {
		MyThread mt = new MyThread();
		System.out.println("begin == " + mt.isAlive());
		mt.run();
		mt.start();
		System.out.println("end == " + mt.isAlive());
	}

	public static void main(String[] args) throws InterruptedException {
		StopThread mt = new StopThread();
		mt.start();
		Thread.sleep(3000);
		mt.interrupt();
		Thread.sleep(3000);
		System.out.println(mt.isInterrupted());
		//		System.out.println("是否停止？" + mt.interrupted());
		//		System.out.println("是否停止？" + mt.interrupted());
		System.out.println("end!");
		while (true) {
		}

	}

/*	@Test
	public void thread_cannotStopThread_demo() {
		try {
			StopThread st = new StopThread();
			st.start();
			Thread.sleep(2000);
			st.interrupt();
			System.out.println("是否停止？="+st.interrupted());
			System.out.println("是否停止？="+st.interrupted());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		while(true){}
	}*/

	@Test
	public void fun_suspendAndResume() {
		try {
			SuspendAndResumeDemo sart = new SuspendAndResumeDemo();
			sart.start();
			Thread.sleep(5000);
			sart.suspend();
			System.out.println(" A= " + System.currentTimeMillis() + " i= " + sart.getI());
			Thread.sleep(5000);
			sart.suspend();
			System.out.println(" A= " + System.currentTimeMillis() + " i= " + sart.getI());
			Thread.sleep(5000);
			sart.resume();
			Thread.sleep(5000);
			sart.suspend();
			System.out.println(" B= " + System.currentTimeMillis() + " i= " + sart.getI());
			Thread.sleep(5000);
			System.out.println(" B= " + System.currentTimeMillis() + " i= " + sart.getI());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
