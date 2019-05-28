package com.liuyq.thread.scheduledthreadpoolservice;

import java.util.TimerTask;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by liuyq on 2019/5/28.
 *  建议心跳
 */
public class MyTask extends TimerTask {
    /**
     * 定时任务
     */
    private final ScheduledExecutorService scheduler;

    /**
     * 子任务
     */
    private final Runnable task;

    /**
     * 执行字子任务线程池
     */
    private final ThreadPoolExecutor executor;

    /**
     * 子任务超时时间
     */
    private final long timeoutMillis;


    public MyTask(ScheduledExecutorService scheduler, ThreadPoolExecutor executor, Runnable task, long timeoutMillis) {
        this.scheduler = scheduler;
        this.executor = executor;
        this.task = task;
        this.timeoutMillis = timeoutMillis;
    }

    @Override
    public void run() {
        Future<?> future = null;
        try{
            future = executor.submit(task);
            //等待任务执行完成或超时
            future.get(timeoutMillis, TimeUnit.MILLISECONDS);

        } catch(Exception e){
            e.printStackTrace();
        }finally {
            //取消未完成任务
            if (future != null) {
                future.cancel(true);
            }

            if (!scheduler.isShutdown()) {
                scheduler.schedule(this, timeoutMillis, TimeUnit.MILLISECONDS);
            }
        }
    }
}
