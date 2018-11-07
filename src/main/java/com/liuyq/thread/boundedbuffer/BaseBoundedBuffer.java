package com.liuyq.thread.boundedbuffer;

/**
 * Created by liuyq on 2018/11/7.
 * 有界缓存基类
 */
public abstract class BaseBoundedBuffer<T> {
    private Object[] buf ;
    private int head,tail,count;

    protected BaseBoundedBuffer(int capacity){
        this.head=0;
        this.tail=0;
        this.count=0;
        this.buf=new Object[capacity];
    }
    protected synchronized void doPut(T t){
        buf[tail]=t;
        if(++tail==buf.length)
            tail=0;
        ++count;
    }
    protected synchronized T doGet(){
        Object obj=buf[head];
        buf[head]=null;
        if(++head==buf.length)
            head=0;
        --count;
        return (T)obj;
    }
    protected synchronized boolean isFull(){
        return count==buf.length;
    }
    protected synchronized boolean isEmpty(){
        return count==0;
    }
}
