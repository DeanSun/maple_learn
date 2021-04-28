package com.compile;

public class SynchronizedDemo {
    public void method() {
        synchronized (this) {
            System.out.println("synchronized code block");
        }
    }
}
