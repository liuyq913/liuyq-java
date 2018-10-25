package com.liuyq.jdk.util;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by liuyq on 2018/10/25.
 * Hash多线程情况下扩容，会死锁
 */
public class HashMapDeadLock extends Thread{
    //一个容量小的HashMap
    private Map<Integer, Integer> map = new HashMap<>(2);
    private AtomicInteger atomicInteger = new AtomicInteger();

    @Override
    public void run(){
        while (atomicInteger.get()<1000){
            map.put(atomicInteger.get(), atomicInteger.get());
            atomicInteger.getAndIncrement();
        }
    }

    public static  void main(String[] args){
        HashMapDeadLock hashMapDeadLock1 = new HashMapDeadLock();
        HashMapDeadLock hashMapDeadLock2 = new HashMapDeadLock();
        HashMapDeadLock hashMapDeadLock3 = new HashMapDeadLock();
        HashMapDeadLock hashMapDeadLock4 = new HashMapDeadLock();
        HashMapDeadLock hashMapDeadLock5 = new HashMapDeadLock();
        HashMapDeadLock hashMapDeadLock6 = new HashMapDeadLock();
        HashMapDeadLock hashMapDeadLock7 = new HashMapDeadLock();
        hashMapDeadLock1.start();
        hashMapDeadLock2.start();
        hashMapDeadLock3.start();
        hashMapDeadLock4.start();
        hashMapDeadLock5.start();
        hashMapDeadLock6.start();
        hashMapDeadLock7.start();
    }
}
