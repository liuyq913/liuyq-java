package com.liuyq.java8.fanxing;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuyq on 2019/8/3.
 */
public class Test {

    public static void main(String[] gars){
        A a = new A();
        List<A> list = new ArrayList<>();
        list.add(a);
        addA(list);


        B b = new B();
        List<B> listb = new ArrayList<>();
        listb.add(b);
        addB(listb);

    }

    public static void addA(List<A> list){
        Common common = new Common();
        common.setList(list);
        common.print();
    }

    public static void addB(List<B> list){
        Common common = new Common();
        common.setList(list);
        common.print();
    }

}
