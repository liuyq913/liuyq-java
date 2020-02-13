package com.liuyq.thread.test;

/**
 * Created by liuyq on 2019/2/28.
 */
public class test3 {

    public static void main(String[] args) {
//        Integer a = 5;
//        addNum(a);
//        System.out.println(a);

        StringBuilder b = new StringBuilder("5");
        addNum(b);
        System.out.print(b.toString());
    }

    static void addNum(StringBuilder b) {
//        a += 10;
        b.append("2");
        b = new StringBuilder("3");
    }

    @org.junit.Test
    public void test1() {
        System.out.println(System.currentTimeMillis());
        System.out.println(((System.currentTimeMillis() - 1578299163000l) / (60 * 60 * 1000)) == 72);

    }
}
