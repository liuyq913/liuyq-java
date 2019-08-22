package com.liuyq.java8.fanxing;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by liuyq on 2019/8/3.
 */
public class Test {
    public static void main(String[] gars) {
        B b = new B();

        b.setA(1);
        b.setB(2);

        List<B> list = Lists.newArrayList();
        list.add(b);

        b.setA(2);
        list.add(b);
    }
}
