package com.liuyq.thread.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by liuyq on 2019/9/2.
 * 基于 Condition 的等待通知机制
 */
public class ConditionWaitAndSign {

    private Lock lock = new ReentrantLock();

    private Condition add = lock.newCondition(); //放

    private Condition remote = lock.newCondition(); //拿

    private Integer addIndex = 0;

    private Integer remoteIndex = 0;

    private int[] a;

    ConditionWaitAndSign(Integer i) {
        a = new int[i];
        addIndex = 0;
        remoteIndex = 0;
    }

    public void add(Integer i) throws InterruptedException {
        lock.lock();

        if (addIndex == a.length) { //满了
            add.await();  //放进去的线程在这里等待
        }
        //没有满 可以放
        addIndex++;
        a[addIndex] = i;

        //唤醒在拿队列等待的线程
        remote.signal();

        lock.unlock();

    }


    public Integer remote() throws InterruptedException {
        lock.lock();

        if (remoteIndex == 0) {
            remote.await(); //没有值了   拿值的再此等待
        }

        remoteIndex--;
        add.signal();       //可以增加了
        lock.unlock();
        return a[remoteIndex];
    }

}
