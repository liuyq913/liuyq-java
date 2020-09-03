package com.liuyq.design.state;

/**
 * @author: liuyuqing
 * @Date: 2020/9/2 22:29
 */
public class SpeedDownState implements RunState {
    @Override
    public void run(LiuXiang1 liuXiang1) {
        System.out.println("--------------减速跑动---------------");
        try {
            Thread.sleep(4000);//假设减速持续4秒
        } catch (InterruptedException e) {
        }
        liuXiang1.setState(LiuXiang1.COMMON);
        System.out.println("------减速状态结束，变为正常状态------");
    }
}
