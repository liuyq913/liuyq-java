package com.liuyq.thread.AbstractQueuedSynchronizerDemo;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * Created by liuyq on 2018/11/9.
 *
 * 二次元闭锁的实现
 *
 * 当线程调用 await方法但是时候，最终会先调用Sync.tryAcquireShared来进行判断，看看是否能
 * 成功获取到，这个时候发现同步状态不为1，则返回失败。线程就会被移到等待线程队列中。
 *
 * 当线程调用signal方法的的时候，会将同步状态改成1， 表示同步器处于完全释放的状态，这个时候，AQS会让所有
 * 等待中的线程重新获取该同步器。
 *
 */
public class OneShotLatch {

    private Sync sync = new Sync();

    //释放
    public void signal(){sync.releaseShared(0);}

    //获取
    public void await() throws InterruptedException {sync.acquireSharedInterruptibly(0);}

    private class Sync extends AbstractQueuedSynchronizer {

        @Override
        protected int tryAcquireShared(int ignoed){
            return (getState() == 1) ? 1:-1; //同步状态 == 1的时候才会返回成功 ，否则返回失败
        }


        @Override
        protected boolean tryReleaseShared(int arg) {
           setState(1); //打开闭锁，在闭锁上阻塞的线程都将被释放
           return true;
        }
    }
}
