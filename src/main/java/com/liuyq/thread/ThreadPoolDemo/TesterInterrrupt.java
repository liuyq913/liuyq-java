package com.liuyq.thread.ThreadPoolDemo;

import org.junit.Test;

import java.util.Date;
import java.util.concurrent.*;

/**
 * Created by liuyq on 2018/12/13.
 */
public class TesterInterrrupt {
    public static void main(String[] args) throws Exception{
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    if(Thread.interrupted()){
                        System.out.println("线程被终止了，开始清理工作并退出");
                        break;
                    }
                    System.out.println(new Date()+" "+ Thread.interrupted());
                }

            }
        });
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
    }

    @Test
    public void test(){
        System.out.println("start study ThreadPoolExecutor");
        CountDownLatch countDownLatch = new CountDownLatch(1);
        /**
         * 这里有个小插曲，核心线程数是1 ，而且队列是LinkedBlockingQueue 无边界队列，下面将执行两个任务，发现第二个任务永远不会执行。
         * 原因：在任务小于或者等于核心线程的时候，任务不管队列满不满都会被执行，当任务大于核心线程数的时候，核心线程数会执行任务，对于的任务
         * 会被放在队列里面，核心线程一个个消费，当任务撑满队列的时候，才会创新的线程来执行任务
         *
         */
        Executor es = new ThreadPoolExecutor(1, 10,
                60L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>());
        es.execute(new Runnable() {
            @Override
            public void run() {
                while(1==1){
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Monitor...");
                }
            }
        });

        es.execute(new Runnable() {
            int count =0;
            @Override
            public void run() {
                System.out.println("run in 2th thread.");
                while(count<100000){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("正在爬取页面..."+ count+"次数");
                    count++;
                }
                countDownLatch.countDown();
            }
        });

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
