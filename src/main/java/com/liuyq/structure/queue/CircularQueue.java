package com.liuyq.structure.queue;

/**
 * @author liuyq
 * @date 2019/6/5 0005 下午 23:16
 *
 * 循环队列
 * 循环队列队满和队空的判断条件
 * 队空 head==tail
 * 队满 (tail+1)% 队列里面的个数 = head
 *
 */
public class CircularQueue {

    private String[] array;
    private Integer n = 0;// 队列的容量
    private Integer head = 0;//头指针
    private Integer tail = 0;//尾指针

    private CircularQueue(Integer n) {
        this.array = new String[n];
        this.n = n;
    }

    /**
     * 入队
     *
     * @param s
     * @return
     */
    public Boolean enqueue(String s) {

    }
}
