package com.liuyq.design.state;

/**
 * @author: liuyuqing
 * @Date: 2020/9/2 22:24
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
      /*  LiuXiang liuXiang = new LiuXiang();
        liuXiang.startRun();
        liuXiang.setState(LiuXiang.SPEED_UP);
        Thread.sleep(5000);
        liuXiang.setState(LiuXiang.SPEED_DOWN);
        Thread.sleep(5000);
        liuXiang.setState(LiuXiang.SWIM);
        Thread.sleep(5000);
        liuXiang.stopRun();*/

        LiuXiang1 liuXiang1 = new LiuXiang1();
        liuXiang1.startRun();
        liuXiang1.setState(LiuXiang1.SPEED_UP);
        Thread.sleep(5000);
        liuXiang1.setState(LiuXiang1.SPEED_DOWN);
        Thread.sleep(5000);
        liuXiang1.setState(LiuXiang1.SWIM);
        Thread.sleep(5000);
        liuXiang1.stopRun();
    }
}
