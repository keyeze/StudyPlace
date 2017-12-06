package com.chan.JavaMutiThreadProgramming.Demo;

import org.junit.Test;

import java.security.SecureRandom;

/**
 * Created by keyez on 2017/11/19.
 */
public class Example_2_1_7 {
    @Test
    public void fun() {
        Service service = new Service();
        Thread a = new Thread(service::testMethod);
        a.setName("a");
        a.start();
        Thread b = new Thread(service::testMethod);
        b.setName("b");
        b.start();
        Thread c = new Thread(service::testMethod);


    }

}

class Service {
    private SecureRandom sr;

    {
        sr = new SecureRandom();
        sr.setSeed(System.currentTimeMillis());
    }

    synchronized public void testMethod() {
        while (true) {
            try {
                switch (Thread.currentThread().getName()) {
                    case "a":
                        threadA();
                        break;
                    case "b":
                        threadB();
                        break;
                    default:
                        threadOther();
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void threadA() {

        sr.nextDouble();
        int i = 1;
        while (i == 1) {
            if ("0.123456".equals((sr.nextDouble() + "").substring(0, 8))) {

                System.out.println("ThreadName=" +
                        Thread.currentThread().getName() +
                        " run exceptionTime = " +
                        System.currentTimeMillis());
                Integer.parseInt("a");
            }

        }
    }

    private void threadB() throws Exception {
        int i = 1;
        while (i == 1) {
            if ("0.123456".equals((sr.doubles() + "").substring(0, 8))) {
                throw new Exception();
            }

        }
    }

    private void threadOther() {
        int i = 1;
        while (i == 1) {
            System.out.println(Thread.currentThread().getName() + " 运行中... ");

        }
    }
}