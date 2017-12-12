package com.chan.javaBfbcHxffYKj;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by keyez on 2017/12/6.
 */
public class SemaphoreDemo extends AbstractThreadDemo {
    private static final int MAX_PERMIT_NUM = 4;
    private Semaphore unfairSemaphore = new Semaphore(MAX_PERMIT_NUM);//与进入等待队列顺序无关
    private Semaphore semaphore = new Semaphore(MAX_PERMIT_NUM, true);//与进入等待队列顺序有关

    @Test
    public void semaphoreSimpleUsing() {
        Runnable runnable = () -> {
            try {
//                speak("获取Semaphore资源...");
                unfairSemaphore.acquire();
                speak("获取Semaphore获取成功,正在执行方法中...");
                Thread.sleep(5000);
//                speak("运行完成...");
            } catch (InterruptedException e) {
            } finally {
//                speak("释放Semaphore资源...");
                unfairSemaphore.release();
            }

        };
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < MAX_PERMIT_NUM * 10; i++) {
            Thread thread = new Thread(runnable);
            thread.setName("Thread_" + i);
            thread.setPriority(i % 10 + 1);
            thread.start();
            threads.add(thread);
        }
        //todo:这里可以改进.
        while (true) {
        }

    }

    @Test
    public void availableAndDrainPermitsDemo() throws InterruptedException {
        Runnable runnable = () -> {
            try {
                unfairSemaphore.acquire();
                Thread.sleep(10000);
            } catch (InterruptedException e) {
            } finally {
                unfairSemaphore.release();
            }
        };
        List<Thread> threads = getThreadList(runnable, 2);
        Thread.sleep(500);
        System.out.println(unfairSemaphore.availablePermits());//返回空闲信号
        System.out.println(unfairSemaphore.drainPermits());//清0,返回空闲信号
        System.out.println(unfairSemaphore.availablePermits());
        //todo:这里可以改进.
        while (true) {
        }

    }

    @Test
    public void hasQueuedThreadsAndGetQueueLengthDemo() throws InterruptedException {
        Runnable runnable = () -> {
            try {
                unfairSemaphore.acquire();
                Thread.sleep(10000);
            } catch (InterruptedException e) {
            } finally {
                unfairSemaphore.release();
            }
        };

        List<Thread> threads = getThreadList(runnable, MAX_PERMIT_NUM * 10);
        Thread.sleep(500);
        //是否存在等待进程
        System.out.println(unfairSemaphore.hasQueuedThreads());
        //获取等待进程长度
        System.out.println(unfairSemaphore.getQueueLength());
        //todo:这里可以改进.
        while (true) {
        }

    }

    @Test
    public void tryAcquireDemo() throws InterruptedException {
        unfairSemaphore.tryAcquire(3, TimeUnit.SECONDS);
        unfairSemaphore.release();

    }

    @Test
    public void unknowTest() {
        Semaphore semaphore = new Semaphore(3);
        ReentrantLock lock = new ReentrantLock();
        Runnable runnable = () -> {
            try {
                semaphore.acquire();
                speak(" 准备 ....");
                lock.lock();
                speak(" 开始 sayHello ....");
                for (int i = 0; i < 5; i++) {
                    speak(" 打印:" + i);
                }
                speak("结束 sayHello");
                lock.unlock();
                semaphore.release();
                speak("结束...");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        List<Thread> threads = getThreadList(runnable, MAX_PERMIT_NUM * 3);
        while (true) {
        }
    }


}


