package com.chan.javaBfbcHxffYKj;

import org.junit.Test;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

/**
 * @author Flandre#CtChan
 */
public class CountDownLatchDemo extends AbstractThreadDemo {
    private CountDownLatch down = new CountDownLatch(5);
    private Semaphore semaphore = new Semaphore(2);

    @Test
    public void test() {
        Runnable runnable = () -> {
            try {
                speak("准备...");
                semaphore.acquire();
                speak("处理数据中...");
                Thread.sleep(5000);
                down.countDown();
                speak("计数点-1");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread thread = new Thread(() -> {
            try {
                speak("等待" + down.getCount() + "个计数完成..");
                down.await();
                speak("等待结束...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        List<Thread> threads = getThreadList(runnable, 5);
        while (true) {

        }

    }


}
