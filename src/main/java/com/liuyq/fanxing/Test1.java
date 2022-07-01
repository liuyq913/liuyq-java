package com.liuyq.fanxing;

import java.util.ArrayList;

/**
 * @author liuyuqing
 * @className Test1
 * @description
 * @date 2022/6/29 9:40 上午
 */
public class Test1 {


    public static void test1() {
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("abc");

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(123);

        System.out.println(list1.getClass() == list2.getClass()); // true
    }

    public static <T extends Number> T add(T t, T t2) throws InterruptedException {
        for (; ; ) {
            Thread.sleep(1000);
        }
    }


    public static void main(String[] args) throws InterruptedException {
        add(1, 1);
    }
}
