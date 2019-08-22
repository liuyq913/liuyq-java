package com.liuyq.thread.reentrantlock;

import java.util.concurrent.locks.LockSupport;

/**
 * Created by liuyq on 2019/8/14.
 */
public class TryLockTest2 implements Runnable {
    private volatile int satue = 100;

    @Override
    public void run() {
        int i = 0;
        for (; ; ) {
            i++;
            if (i < satue) {
                System.out.println("执行中。。");
            } else {
                System.out.println("开始停止。。。");

                LockSupport.park(this);

            }
            System.out.println("执行结束。。。" + i);

        }
    }

    public static void main(String[] args) {
        TryLockTest2 tryLockTest2 = new TryLockTest2();
        tryLockTest2.run();
    }


}
