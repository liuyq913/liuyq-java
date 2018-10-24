package com.liuyq.thread.ThreadPoolDemo.aturatedstrategy;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by liuyq on 2018/10/24.
 *
 * CallerRunsPolicy :
 * 该策略只要线程池未关闭，该策略直接在调用者线程中，
 * 运行当前被丢弃的任务（白话就是不会抛弃线程，也不抛出异常，而是将任务回退到调用者，从而降低新任务的流量
 */
public class CallerRunsPolicyDemo {
    public static void main(String[] agrs){
        // 核心线程数1 线程池最大容量1,工作队列1
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(1, 1,
                0, TimeUnit.SECONDS, new LinkedBlockingQueue<>(1));
        //设置饱和策略 CallerRunsPolicy---拒绝策略  //回退给客户端
        threadPool.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        for(int i= 0 ;i<5;i++){
            try {
                threadPool.submit(new AbortPolicyDemo.MyRunable());
            }catch (RejectedExecutionException e){
                e.printStackTrace();
            }


        }
        threadPool.shutdown();
    }

    static class MyRunable implements Runnable{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getId()+"正在执行-----");
            try {
                Thread.sleep(500);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
