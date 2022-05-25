package com.liuyq.jdk.util;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liuyq on 2018/3/21.
 */
public class HashMapTest {
    @Test
    public void test() {
        Map map = new HashMap();
        map.put("1", "hello");
        map.put("1", "world");
        System.out.println(map);
    }

    @Test
    public void test1() {
        Integer i = 71523;
        Integer i2 = 71523;
        System.out.println(i == i2);
    }

    @Test
    public void testRemove() {
        Map map = new HashMap();
        map.put("1", "hello");
        map.put(null, null);
        map.put(null, "123");
        map.remove("1");
        System.out.println(map.get(null));
    }

    @Test
    public void test3() {
        String s = "1";
        int hash = s.hashCode();
        // Hashtable hashtable
        System.out.println(hash);
        System.out.println(700000 >>> 16);
        System.out.println(8 >>> 16);

    }

    @Test
    public void test2() {
        Integer I = 4;
        System.out.println(4 >> 1);
    }

    @Test
    public void test5() {
        int i;
        for (i = 0; i < 10; ++i) ;
        System.out.println(i);
    }

    @Test
    public void test6() {
        Map<String, String> map = new HashMap();
        map.put("hashMap", "hashMap");
    }

    @Test
    public void test7() {
        String s = "hashMap";

        int hashCodes = s.hashCode();
        System.out.println("hashCode = " + hashCodes);

        int rightMove = hashCodes >>> 16;

        System.out.println("rightMove = " + rightMove);

        int yihuo = hashCodes ^ rightMove;  //异或规则：0^0 = 0 !^0 = 1 0 ^1 = 1  !^1 = 1

        System.out.println("异或后的十进制值 =" + yihuo);

    }


    @Test
    public void test_8() {
        HashMap<Integer, String> map = new HashMap<Integer, String>(2, 0.75f);
        map.put(5, "C");

        new Thread("Thread1") {
            public void run() {
                map.put(7, "B");
                System.out.println(map);
            }

            ;
        }.start();
        new Thread("Thread2") {
            public void run() {
                map.put(3, "A");
                System.out.println(map);
            }

            ;
        }.start();

    }
}