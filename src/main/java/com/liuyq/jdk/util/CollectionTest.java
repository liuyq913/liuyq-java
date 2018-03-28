package com.liuyq.jdk.util;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

/**
 * Created by liuyq on 2018/3/13.
 */
public class CollectionTest {
    @Test
    public void test(){
        List list = Lists.newArrayList();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        String[] s = (String[])list.toArray(new Integer[]{7});
        for(int i =0 ;i <s.length ;i++){
            System.out.println(s[i]);
        }
    }
    @Test
    public void test2(){
        String[] s = new String[0];
        String[] s1 = new String[0];
        System.out.println(s1 == s);
    }

}
