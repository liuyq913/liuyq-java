package com.liuyq.thread.TwinsLock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by liuyq on 2019/8/23.
 */
public class CacheDemo {
    private Map<String, Object> cache = new HashMap<String, Object>();

    private ReadWriteLock rwriteLock = new ReentrantReadWriteLock();

    private Lock readLock = rwriteLock.readLock();

    private Lock writeLock = rwriteLock.writeLock();

    public volatile boolean update = false;

    public void processDate() {
        //readLock.lock();

        //writeLock.lock(); //存在读锁  无法获取写锁   自旋

        //这里读锁可以获取成功
        //writeLock.lock();
        //readLock.lock();


        readLock.lock();
        if (!update) {
          // 必须先释放读锁
            readLock.unlock();
                    // 锁降级从写锁获取到开始
            writeLock.lock();
            try {
                if (!update) {
                  // 准备数据的流程（略）
                    update = true;
                }
                readLock.lock();
            } finally {
                writeLock.unlock();
            }
              // 锁降级完成，写锁降级为读锁
        }
        try {
              // 使用数据的流程（略）
        } finally {
            readLock.unlock();
        }
    }

    public static void main(String[] ars) {
        CacheDemo cacheDemo = new CacheDemo();
        cacheDemo.processDate();
    }

}

