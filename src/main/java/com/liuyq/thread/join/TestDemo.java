package com.liuyq.thread.join;

/**
 * Created by liuyq on 2019/2/27.
 */
class BThread extends Thread {
    public BThread() {
        super("[BThread] Thread");
    };
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " start.");
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println(threadName + " loop at " + i);
                Thread.sleep(1000);
            }
            System.out.println(threadName + " end.");
        } catch (Exception e) {
            System.out.println("Exception from " + threadName + ".run");
        }
    }
}
class AThread extends Thread {
    BThread bt;
    public AThread(BThread bt) {
        super("[AThread] Thread");
        this.bt = bt;
    }
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " start.");
        try {
            bt.join(); //等待bt执行完
            System.out.println(threadName + " end.");
        } catch (Exception e) {
            System.out.println("Exception from " + threadName + ".run");
        }
    }
}
public class TestDemo {
    public static void main(String[] args) {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " start.");
        BThread bt = new BThread();
        AThread at = new AThread(bt);
        try {
            bt.start();
            Thread.sleep(2000);
            at.start();
            at.join(); //等待at执行完
        } catch (Exception e) {
            System.out.println("Exception from main");
        }
        System.out.println(threadName + " end!");
    }
}
