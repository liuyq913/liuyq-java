package com.liuyq.thread.TwinsLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Created by liuyq on 2019/8/22.
 * <p>
 * 同时一个两个线程获取到锁， 其他的都阻塞
 */
public class TwinsLock implements Lock {


    private final Sync sync = new Sync(2);

    private static final class Sync extends AbstractQueuedSynchronizer {
        public Sync(Integer num) {
            if (num < 0) throw new IllegalArgumentException("num is not zore");
            setState(num);
        }

        @Override
        public int tryAcquireShared(int reductNum) {
            for (; ; ) {
                int current = getState();

                int newNum = current - reductNum;
                /**
                 * @see java.util.concurrent.locks.AbstractQueuedSynchronizer {@link #acquireShared(int)}
                 */
                //小于0 表示已经有两个线程获取到了锁，tryAcquireShare< 0 则返回true,入等待队列
                if (newNum < 0 || compareAndSetState(current, newNum)) {
                    return newNum;
                }
            }
        }

        @Override
        public boolean tryReleaseShared(int reductNum) {
            for (; ;) {
                int current = getState();

                int newNum = current + reductNum;

                if(compareAndSetState(current, newNum)){
                    return true;
                }
            }
        }


    }

    @Override
    public void lock() {
        sync.acquireShared(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        sync.releaseShared(1);
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
