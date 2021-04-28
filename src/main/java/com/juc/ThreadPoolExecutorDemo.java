package com.juc;

import org.springframework.format.number.PercentStyleFormatter;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorDemo {

    public static final int CORE_POOL_SIZE = 5;
    public static final int MAX_POOL_SIZE = 10;
    public static final int QUEUE_CAPACITY = 100;
    public static final Long KEEP_ALIVE_TIME = 1L;

    public static void main(String[] args) {
        TimeUnit unit;
        BlockingQueue workQueue;
        ThreadPoolExecutor executor = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME, TimeUnit.SECONDS, new ArrayBlockingQueue<>(QUEUE_CAPACITY), new ThreadPoolExecutor.CallerRunsPolicy());

        for (int i = 0; i < 10; i++) {
            Runnable worker = new MyRunnable("" + i);

            executor.execute(worker);
        }

        executor.shutdown();
        while (!executor.isTerminated()){

        }
        System.out.println("Finish all threads.");
    }
}
