package com.liuyq.thread.scheduledthreadpoolservice;

import java.util.concurrent.*;

/**
 * Created by liuyq on 2019/5/28.
 */
public class Demo {
    public static void main(String[] agrs) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                1, 1, 0, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());

        scheduledExecutorService.schedule(new MyTask(scheduledExecutorService, threadPoolExecutor, new Task(), 3000), 3, TimeUnit.SECONDS);
    }
}
