package com.liuyq.thread.boundedbuffer;

/**
 * Created by liuyq on 2018/11/7.
 * 条件队列 实现的有界缓存
 */
public class BoundeBuffer<T> extends BaseBoundedBuffer{

    protected BoundeBuffer(int size) {
        super(size);
    }


    public synchronized void put(T t) throws InterruptedException {
        //在条件队列满的时候等待  阻塞
        while(isFull())
            wait();
        doPut(t); //不满，则往里面放，并且通知其他的线程
        notifyAll();
    }

    public synchronized T take() throws InterruptedException{
        while(isEmpty()) //空一直等待  阻塞  直至非空
            wait();
        T t = (T) doGet();
        notifyAll();
        return t;
    }
}
