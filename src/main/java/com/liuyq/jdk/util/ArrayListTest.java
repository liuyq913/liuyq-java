package com.liuyq.jdk.util;

import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by liuyq on 2018/3/16.
 */
public class ArrayListTest {
    @Test
    public void test(){
        ArrayList list = new ArrayList(10);
        System.out.println(list);
        System.out.println(list.size());
    }

    @Test
    public void test2(){
        char[] ints = new char[10];
        System.out.println(ints.length);
        /*for(int i = 0;i<ints.length;i++)
            System.out.println(ints[i]);*/
    }
}
