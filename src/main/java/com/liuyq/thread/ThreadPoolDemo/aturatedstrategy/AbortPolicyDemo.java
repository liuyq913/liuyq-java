package com.liuyq.thread.ThreadPoolDemo.aturatedstrategy;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by liuyq on 2018/10/24.
 * 饱和策略之Abort (终止) 会抛出RejectedExecutionException
 */
public class AbortPolicyDemo {
    public static void main(String[] agrs){
        // 核心线程数1 线程池最大容量1,工作队列1
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(1, 1,
                 0, TimeUnit.SECONDS, new LinkedBlockingQueue<>(1));
        //设置饱和策略 AbortPolicy---拒绝策略 //客户端可以进行捕获
        threadPool.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        for(int i= 0 ;i<5;i++){
            try {
                threadPool.submit(new MyRunable());
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
