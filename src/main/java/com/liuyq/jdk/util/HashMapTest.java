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
}
