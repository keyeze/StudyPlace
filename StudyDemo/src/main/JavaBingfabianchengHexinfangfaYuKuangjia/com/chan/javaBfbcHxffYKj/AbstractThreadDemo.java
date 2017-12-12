package com.chan.javaBfbcHxffYKj;

import sun.rmi.transport.proxy.CGIHandler;

import java.lang.reflect.Method;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author Flandre#CtChan
 */
public abstract class AbstractThreadDemo {
    private static final int DEFAULT_TV = 500;


    private static class Singleton {
        private static SecureRandom random = new SecureRandom();
        private static ThreadLocal<Long> time = new ThreadLocal<>();
        private static ThreadLocal<Long> lasttime = new ThreadLocal<>();
    }

    static void speak(Object say) {
        System.out.println(Thread.currentThread().getName() + ":" + say);
    }

    List<Thread> getThreadList(Runnable runnable, Integer number) {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            Thread thread = new Thread(runnable);
            thread.setName("Thread_" + i);
            thread.setPriority(i % 10 + 1);
            thread.start();
            threads.add(thread);
        }
        return threads;
    }

    static Integer randomSecond() {
        Integer i = Singleton.random.nextInt(10);
        return i * DEFAULT_TV;
    }

    static void deadLoop(Runnable runnable, int dalay) {
        try {
            while (true) {
                if (runnable != null) {
                    runnable.run();
                }
                Thread.sleep(dalay);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static void deadLoop() {
        deadLoop(null, 200);
    }

    static void startWork() {
        Long tempTime = System.currentTimeMillis();
        Singleton.time.set(tempTime);
        Singleton.time.set(tempTime);
    }

    static long stageWork() {
        Long tempTime = System.currentTimeMillis();
        try {
            Long prevTime;
            if (Singleton.lasttime.get() == null) {
                prevTime = Singleton.time.get();
            } else {
                prevTime = Singleton.lasttime.get();
            }
            return prevTime == null ? 0 : tempTime - prevTime;
        } finally {
            Singleton.lasttime.set(tempTime);
        }
    }

    static long endWork() {
        try {
            return Singleton.time.get() == null ? 0 : System.currentTimeMillis() - Singleton.time.get();
        } finally {
            Singleton.time.set(null);
            Singleton.lasttime.set(null);
        }

    }

}
