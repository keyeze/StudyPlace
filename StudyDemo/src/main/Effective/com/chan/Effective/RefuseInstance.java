package com.chan.Effective;

//Non-instantiable utility class
public class RefuseInstance {
    // Suppress default constructor for non-instantiability
    private RefuseInstance() {
        throw new AssertionError();
    }
}
