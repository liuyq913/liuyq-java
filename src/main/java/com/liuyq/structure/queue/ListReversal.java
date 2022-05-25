package com.liuyq.structure.queue;

import org.apache.poi.ss.formula.functions.T;

/**
 * @author liuyuqing
 * @className ListReversal
 * @description
 * @date 2022/5/25 10:58 上午
 */
public class ListReversal {
    static class Note<T> {
        T data;
        Note<T> next;

        public Note(T data) {
            this.data = data;
            this.next = null;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Note getNext() {
            return next;
        }

        public void setNext(Note next) {
            this.next = next;
        }
    }

    public static Note<T> reversal(Note<T> head) {
        Note pre = null;
        Note curr = head;

        while (curr != null) {
            Note currNext = curr.next;
            curr.setNext(pre);

            pre = curr;
            curr = currNext;
        }
        return pre;

    }


    public static void main(String[] agrs) {

        Note t1 = new Note(1);
        Note t2 = new Note(2);
        Note t3 = new Note(3);
        Note t4 = new Note(4);
        Note t5 = new Note(5);
        Note t6 = new Note(6);
        Note t7 = new Note(7);
        Note t8 = new Note(8);
        Note t9 = new Note(9);
        Note t10 = new Note(10);

        t1.setNext(t2);
        t2.setNext(t3);
        t3.setNext(t4);
        t4.setNext(t5);
        t5.setNext(t6);
        t6.setNext(t7);
        t7.setNext(t8);
        t8.setNext(t9);
        t9.setNext(t10);


        Note note = reversal(t1);
        System.out.println(note);

    }

}
