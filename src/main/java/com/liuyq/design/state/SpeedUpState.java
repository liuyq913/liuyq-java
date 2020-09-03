package com.liuyq.design.state;

/**
 * @author: liuyuqing
 * @Date: 2020/9/2 22:28
 */
public class SpeedUpState implements RunState{
    @Override
    public void run(LiuXiang1 liuXiang1) {
        System.out.println("--------------加速跑动---------------");
        try {
            Thread.sleep(4000);//假设加速持续4秒
        } catch (InterruptedException e) {}
        liuXiang1.setState(LiuXiang1.COMMON);
        System.out.println("------加速状态结束，变为正常状态------");
    }
}
