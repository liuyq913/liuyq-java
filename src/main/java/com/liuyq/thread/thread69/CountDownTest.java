package com.liuyq.thread.thread69;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

/**
 * Created by liuyq on 2018/3/1.
 */
public class CountDownTest {
    public static long time(Executor executor, int concurrency, final Runnable action) throws InterruptedException{

        final CountDownLatch ready = new CountDownLatch(concurrency);
        final CountDownLatch start = new CountDownLatch(1);
        final CountDownLatch done = new CountDownLatch(concurrency);
        for (int i = 0; i < concurrency; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    ready.countDown();
                    try {
                        start.await(); //当前线程在锁存器倒计数至零之前一直等待（线程一直在这里等待）
                        action.run();
                    }catch (InterruptedException e){
                        Thread.currentThread().interrupt();
                    }finally {
                        done.countDown();
                    }
                }
            });
        }
        ready.await();//主线程等待，ready减到0的时候才苏醒
        long startNanos = System.nanoTime();
        start.countDown(); //线程开始跑
        done.await();//主线程一直等待（done减0的时候才苏醒）
        return System.nanoTime() - startNanos;
    }

}
