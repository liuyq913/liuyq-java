package com.liuyq.jdk.util;

import org.junit.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by liuyq on 2018/3/21.
 */
public class AbstractMapTest {
    @Test
    public void testValues(){
        Map map = new HashMap();
        map.put("1","hello");
        map.put("2","world");
        Set set = map.keySet();
        Collection value = map.values();
    }
}
