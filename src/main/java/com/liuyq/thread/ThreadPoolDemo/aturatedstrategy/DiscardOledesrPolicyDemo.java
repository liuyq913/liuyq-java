package com.liuyq.thread.ThreadPoolDemo.aturatedstrategy;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by liuyq on 2018/10/24.
 * 拒绝策略：抛弃最旧的
 *
 * 注意：
 *  如果工作队列是一个优先级的工作队列，DiscardOledesrPolicy的拒绝策略将会
 *  拒绝掉优先级别最高的
 */
public class DiscardOledesrPolicyDemo{
    public static void main(String[] agrs){
        // 核心线程数1 线程池最大容量1,工作队列1
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(1, 1,
                0, TimeUnit.SECONDS, new LinkedBlockingQueue<>(1));

        /**
         * DiscardOledesrPolicy 拒绝策略淘汰最旧的
         *
         * DiscardPolicy 丢弃策略：该策略默默地丢弃无法处理的任务，不予任何处理
         */
        threadPool.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardOldestPolicy());
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
