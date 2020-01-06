package com.liuyq.thread.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Auther: liuyuqing
 * @Date: 2020-01-06 11:44
 * @Description: 所有线程准备好，等待然后一起执行，可以并发请求接口
 */
public class CyclicBarrierTask {

    static CyclicBarrier barrier = new CyclicBarrier(10);

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new TaskInsert(barrier).start();
        }
    }

}

class TaskInsert extends Thread {
    private CyclicBarrier barrier;

    public TaskInsert(CyclicBarrier cyclicBarrier) {
        this.barrier = cyclicBarrier;
    }

    public void run() {
        try {
            System.out.println("getNumberWaiting---"+barrier.getNumberWaiting());
            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + "开始insert");

    }
}
