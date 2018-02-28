package com.liuyq.thread.thread66;

import java.util.concurrent.TimeUnit;

/**
 * Created by liuyq on 2018/2/28.
 */
public class StopThread {
    private static boolean stopRequested;

    public static void main(String[] agrs)throws InterruptedException{
        Thread backgroundThread = new Thread(new Runnable() {
            @Override
            public void run() {
                int i =0;
                while(!stopRequested)
                    i++;
            }
        });
        backgroundThread.start();

        TimeUnit.SECONDS.sleep(1);
       //由于stopRequested值的改变没有同步，就不能保证后台线程看到stopRequested的改变
        //所有后台线程一直在循环
        stopRequested = true;
    }
}
