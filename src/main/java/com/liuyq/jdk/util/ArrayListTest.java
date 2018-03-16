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
}
