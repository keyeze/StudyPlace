package com.chan.javaBfbcHxffYKj;

import org.junit.Test;

import java.security.SecureRandom;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by keyez on 2017/12/8.
 */
public class CyclicBarrierDemo extends AbstractThreadDemo {
    /**
     * isBroken 的 Demo
     * 如果 线程 在 CyclicBarrier.await 过程中接收到 打断异常,会让所有处于 CyclicBarrier.await 的线程处于
     * isBroken 的阶段,并进入 BrokenBarrierException异常处理.
     */
    @Test
    public void isBrokenDemo() throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, () -> {
            System.out.println("运动员到齐");
        });
        SecureRandom random = new SecureRandom();
        Runnable runnable = () -> {
            try {
                speak("做准备工作...");
                Thread.sleep(Math.abs(random.nextInt(10) * 1000));
                speak("准备就绪");
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                speak("InterruptedException ->" + cyclicBarrier.isBroken());
            } catch (BrokenBarrierException e) {
                speak("BrokenBarrierException ->" + cyclicBarrier.isBroken());
            }
        };
        List<Thread> runners = getThreadList(runnable, 5);
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(10000);
                runners.get(2).interrupt();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();

        while (true) {
            System.out.println(cyclicBarrier.isBroken());
            Thread.sleep(200);

        }

    }

    @Test
    public void getNumberWaitingDemo() throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, () -> {
            System.out.println("运动员到齐");
        });
        SecureRandom random = new SecureRandom();
        Runnable runnable = () -> {
            try {
                speak("做准备工作...");
                Thread.sleep(Math.abs(random.nextInt(10) * 1000));
                speak("准备就绪");
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                speak("InterruptedException ->" + cyclicBarrier.isBroken());
            } catch (BrokenBarrierException e) {
                speak("BrokenBarrierException ->" + cyclicBarrier.isBroken());
            }
        };
        List<Thread> runners = getThreadList(runnable, 5);

        while (true) {
            System.out.println(cyclicBarrier.getNumberWaiting() + " .. " + cyclicBarrier.getParties());
            Thread.sleep(200);

        }
    }
}
