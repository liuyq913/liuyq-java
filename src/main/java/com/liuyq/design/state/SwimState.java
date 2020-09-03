package com.liuyq.design.state;

/**
 * @author: liuyuqing
 * @Date: 2020/9/2 22:29
 */
public class SwimState implements RunState {
    @Override
    public void run(LiuXiang1 liuXiang1) {
        System.out.println("--------------不能跑动---------------");
        try {
            Thread.sleep(2000);//假设眩晕持续2秒
        } catch (InterruptedException e) {
        }
        liuXiang1.setState(LiuXiang1.COMMON);
        System.out.println("------眩晕状态结束，变为正常状态------");
    }
}
