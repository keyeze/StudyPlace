package com.chan.Effective.Singleton.Demo;

import java.io.ObjectInputStream;
import java.io.Serializable;

public class GlobalSingleton {
    enum MyObject {
        INSTANCE;
    }

}

class Singleton implements Serializable {
    private static final Singleton INSTANCE = new Singleton();

    private Object readResolve() {
        //Return the one true Singleton and let the garbage collector
        //take care of the Singleton impersonator
        return INSTANCE;
    }
}
