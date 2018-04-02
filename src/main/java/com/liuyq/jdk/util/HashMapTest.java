package com.liuyq.jdk.util;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liuyq on 2018/3/21.
 */
public class HashMapTest {
    @Test
    public void test (){
        Map map = new HashMap();
        map.put("1", "hello");
        map.put("1","world");
        System.out.println(map);
    }
    @Test
    public void test1(){
        Integer i= 71523;
        Integer i2 = 71523;
        System.out.println(i == i2);
    }

    @Test
    public void testRemove(){
        Map map = new HashMap();
        map.put("1", "hello");
        map.put(null,null);
        map.put(null,"123");
        map.remove("1");
        System.out.println(map.get(null));
    }
    @Test
    public void test3(){
        String s = "1";
        int hash = s.hashCode();
       // Hashtable hashtable
        System.out.println(hash);
        System.out.println(700000>>>16);
        System.out.println(8>>>16);

    }
    @Test
    public void test2(){
      Integer I = 4;
        System.out.println(4>>1);
    }
    @Test
    public void test5(){
        int i ;
        for( i =0 ;i<10;++i);
        System.out.println(i);
    }
}
