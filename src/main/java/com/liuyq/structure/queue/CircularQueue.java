package com.liuyq.structure.queue;

/**
 * @author liuyq
 * @date 2019/6/5 0005 下午 23:16
 * <p>
 * 循环队列
 * 循环队列队满和队空的判断条件
 * 队空 head==tail
 * 队满 (tail+1)% 数组大小 = head
 * <p>
 * 循环队列的一个特点就是尾指针永远指的是空位置。
 */
public class CircularQueue {

    private String[] array;
    private Integer n = 0;//数组大小
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
        if ((tail + 1) % n == head) return false;// 队满
        array[tail] = s;
        tail = (tail + 1) % n;  //使得 tail一直是在n之内  而且入队之后，tail指向的是一个空位置
        return true;
    }

    /**
     * 出队列
     *
     * @return
     */
    public String dequeue() {
        if (head == tail) return null; //队空
        String temp = array[head];
        head = (head + 1) % n;
        return temp;
    }
}
