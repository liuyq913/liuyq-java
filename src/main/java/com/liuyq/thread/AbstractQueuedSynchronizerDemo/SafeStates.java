package com.liuyq.thread.AbstractQueuedSynchronizerDemo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liuyq on 2018/11/9.
 */
public class SafeStates {
    private final Map<String, String> map;

    public SafeStates (){
        map = new HashMap<>();
        map.put("1","1");
        map.put("2","2");
        map.put("3","3");
    }

    public String getValue(String s){
        return map.get(s);
    }

}
