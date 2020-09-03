package com.liuyq.design.state;

/**
 * @author: liuyuqing
 * @Date: 2020/9/2 22:27
 */
public class LiuXiang1 {
    public static final RunState COMMON = new CommonState();//正常状态

    public static final RunState SPEED_UP = new SpeedUpState();//加速状态

    public static final RunState SPEED_DOWN = new SpeedDownState();//减速状态

    public static final RunState SWIM = new SwimState();//眩晕状态

    private RunState state = COMMON;//默认是正常状态

    private Thread runThread;//跑动线程

    //设置状态
    public void setState(RunState state) {
        this.state = state;
    }
    //停止跑动
    public void stopRun() {
        if (isRunning()) runThread.interrupt();
        System.out.println("--------------停止跑动---------------");
    }
    //开始跑动
    public void startRun() {
        if (isRunning()) {
            return;
        }
        final LiuXiang1 liuXiang1 = this;
        runThread = new Thread(() -> {
            while (!runThread.isInterrupted()) {
                state.run(liuXiang1);
            }
        });
        System.out.println("--------------开始跑动---------------");
        runThread.start();
    }

    private boolean isRunning(){
        return runThread != null && !runThread.isInterrupted();
    }
}
