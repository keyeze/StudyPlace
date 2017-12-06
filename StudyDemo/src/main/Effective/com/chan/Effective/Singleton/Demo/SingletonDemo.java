package com.chan.Effective.Singleton.Demo;

public class SingletonDemo {
    //Singleton with public final field
    public static final Object INSTANCE = new Object();

    private static final Object INSTANCE2 = new Object();

    private SingletonDemo() {    }
    //Singleton with static factory
    public static Object getInstance2(){return INSTANCE2;}

}
