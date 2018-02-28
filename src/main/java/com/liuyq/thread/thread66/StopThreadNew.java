package com.liuyq.thread.thread66;

import java.util.concurrent.TimeUnit;

/**
 * Created by liuyq on 2018/2/28.
 *
 * 为了使程序如期的停止，则需要将stopRequested同步
 */
public class StopThreadNew {
    //boolean域的读和写操作都是原子型的（除了long和double），但是不能保证一个线程的写入的值对于另一个线程将是可见的，所以也需要同步
    private static boolean stopRequest;

    private static synchronized void requestStop(){
        stopRequest = true;
    }
    private static synchronized boolean stopRequest(){
        return stopRequest;
    }

    public static void main(String[] agrs)throws InterruptedException{
        Thread backgroundThread = new Thread(new Runnable() {
            @Override
            public void run() {
                int i=0;
                while(!stopRequest()) i++;
            }
        });
        backgroundThread.start();

        TimeUnit.SECONDS.sleep(1);
        requestStop();
    }
}
