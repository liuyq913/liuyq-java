package com.liuyq.structure.heap.timing;

/**
 * Created by liuyq on 2019/7/26.
 */
public class Task implements Runnable{
    @Override
    public void run() {
        System.out.println("执行任务！！！");
    }
}
