package com.liuyq.structure.heap.timing;

/**
 * Created by liuyq on 2019/7/26.
 */
public class Job {
    //任务开始时间
    private Long startTime;


    private Runnable runnable;

    private int size;

    public Job(Long startTime, Runnable runnable, int size) {
        this.startTime = startTime;
        this.runnable = runnable;
        this.size = size;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Runnable getRunnable() {
        return runnable;
    }

    public void setRunnable(Runnable runnable) {
        this.runnable = runnable;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Job{" +
                "startTime=" + startTime +
                ", runnable=" + runnable +
                ", size=" + size +
                '}';
    }


    public void run() {
        //延迟startTime - System.currentTimeMillis() 之后执行任务

        if (startTime - System.currentTimeMillis() > 0) {
            try {
                System.out.println("休眠"+(startTime - System.currentTimeMillis()));
                Thread.sleep(startTime - System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        runnable.run();
    }
}
