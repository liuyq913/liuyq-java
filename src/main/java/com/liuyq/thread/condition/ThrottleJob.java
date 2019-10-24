package com.liuyq.thread.condition;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThrottleJob {

    private Lock consumerLock = new ReentrantLock();

    private Condition condition = consumerLock.newCondition();

    private volatile AtomicBoolean hasJob = new AtomicBoolean(false);


    /**
     * 最大空闲休眠时间（毫秒）| 5分钟
     */
    private static final long maxDelayTime = TimeUnit.MINUTES.toMillis(5);
    private long delayTime = maxDelayTime >> 6;//初始时休眠时间为最大空闲时间的1/64,约5s


    /**
     * 执行任务线程池
     */
    private ExecutorService poolExecutor = Executors.newFixedThreadPool(1,
            new BasicThreadFactory.Builder()
                    .namingPattern("throttle-push-pool-%d")
                    .daemon(true).build());


    public void doSometing() {
        for (; ; ) {
            try {
                if (consumerLock.tryLock()) {
                    if (!hasJob.get()) {
                        System.out.println("没有任务，进行等待！！！" + Thread.currentThread().getName());
                        if (condition.await(delayTime, TimeUnit.MINUTES)) {
                            System.out.println("被唤醒" + Thread.currentThread().getName());
                        } else {
                            //重复等待时，加大等待时间
                            //重复等待10次后，等待时间固定为最大
                            if (delayTime < maxDelayTime) {
                                delayTime = Long.min(100 + delayTime + (delayTime >> 1), maxDelayTime);
                            }
                        }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                consumerLock.unlock();
            }
        }
    }


    public void submit() {
        poolExecutor.submit(() -> {
            doSometing();
        });
    }

    /**
     * 唤醒所有再条件队列里面的数据
     */
    public void signalAll() {
        if (consumerLock.tryLock()) {
            condition.signalAll(); //被唤醒的线程从awite回来并重新获取锁
        }
        consumerLock.unlock();
    }

    /**
     * 验证是不是同一个线程(是同一个线程)
     */
    public void checkIsSameThread() {
        for (; ; ) {
            poolExecutor.submit(() -> {
                System.out.println(Thread.currentThread().getName());
            });
        }
    }


}
