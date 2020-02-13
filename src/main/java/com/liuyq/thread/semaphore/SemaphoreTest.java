package com.liuyq.thread.semaphore;

import java.util.concurrent.Semaphore;

/**
 * @Auther: liuyuqing
 * @Date: 2019-12-05 15:37
 * @Description:
 */
public class SemaphoreTest {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(6);
        for (int i = 0; i < 1000; i++){
            try {
                semaphore.acquire(); //一个线程多次获取也会减值

                new Thread(()->{
                    System.out.println(Thread.currentThread().getName()+"do someing");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    semaphore.release();
                }).start();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
