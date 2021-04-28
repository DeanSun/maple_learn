package com.juc;

import java.util.concurrent.*;

/**
 * @author Dean
 */
public class CyclicBarrierExample {

    private static final int THREAD_COUNT = 550;

    /**
     需要同步的线程数量
     */
    private static final CyclicBarrier CYCLIC_BARRIER = new CyclicBarrier(5);

    public static void main(String[] args) throws InterruptedException {
        //创建线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(10);

        for (int i = 0; i < THREAD_COUNT; i++) {
            final int threadNum = i;
            Thread.sleep(1000);
            threadPool.execute(()->{
                try{
                    test(threadNum);
                } catch (BrokenBarrierException | InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        threadPool.shutdown();

    }

    public static void test(int threadNum) throws InterruptedException, BrokenBarrierException {
        System.out.println("threadNum : " + threadNum + " is ready.");
        try{
            CYCLIC_BARRIER.await(2000, TimeUnit.MICROSECONDS);
        } catch (Exception e) {
            System.out.println("-----CyclicBarrierException------");
        }
        System.out.println("threadNum ：" + threadNum + " is finish.");
    }

}
