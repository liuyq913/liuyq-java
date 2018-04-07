package com.liuyq.jdk.util;

import java.util.WeakHashMap;

/**
 * Created by Administrator on 2018/4/3 0003.
 */
public class CanonicalMaping {
    public static void main(String[] agrs){
        int size = 1000;
        if(agrs.length>0){
            size = new Integer(agrs[0]);
        }
        WeakHashMapTest.Key[] keys = new WeakHashMapTest.Key[size];
        WeakHashMap<WeakHashMapTest.Key, WeakHashMapTest.Value> map = new WeakHashMap<>();
        for(int i = 0; i<size; i++){
            WeakHashMapTest weakHashMapTest = new WeakHashMapTest();
            WeakHashMapTest.Key k = weakHashMapTest.new Key(Integer.toString(i));
            WeakHashMapTest.Value v = weakHashMapTest.new Value(Integer.toString(i));
            if(i % 3 == 0){
                keys[i] = k;
                map.put(k,v);

            }
        }
        System.gc();
    }
}
