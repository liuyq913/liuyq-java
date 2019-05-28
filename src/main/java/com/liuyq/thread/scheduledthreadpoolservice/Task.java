package com.liuyq.thread.scheduledthreadpoolservice;

/**
 * Created by liuyq on 2019/5/28.
 */
public class Task implements Runnable{
    @Override
    public void run() {
        System.out.println("心跳！！！");
    }
}
