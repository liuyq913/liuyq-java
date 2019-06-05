package com.liuyq.structure.queue;

import org.omg.PortableInterceptor.INACTIVE;

/**
 * @author liuyq
 * @date 2019/6/5 0005 下午 21:31
 * 基于数组实现的队列
 */
public class ArrayQueue {

    private String[] array;
    private Integer n = 0;// 队列的容量
    private Integer head = 0;//头指针
    private Integer tail = 0;//尾指针

    private ArrayQueue(Integer n) {
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
        if (tail == n) {
            if (head == 0) return false; //队列已满

            //反复出队入队操作之后，发现head指针和tail指针一直再往后移动
            for (int i = head; head < tail; i++) {
                array[i - head] = array[head];
            }
            head = 0;
            tail -=head;
        }

        array[tail] = s;
        tail++;
        return true;
    }


    /**
     * 出队
     *
     * @return
     */
    public String dequeue() {
        if (head == tail) return null;
        String s = array[head];
        head++;
        return s;
    }
}
