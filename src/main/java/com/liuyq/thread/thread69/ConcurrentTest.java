package com.liuyq.thread.thread69;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by liuyq on 2018/3/1.
 * 使用concurrent来实现 String.intern方法
 *
 * String.intern（当调用 intern 方法时，如果池已经包含一个等于此 String
 * 对象的字符串（用 equals(Object) 方法确定），则返回池中的字符串。
 * 否则，将此 String 对象添加到池中，并返回此 String 对象的引用。）
 */
public class ConcurrentTest {
    private static final ConcurrentMap<String, String> map = new ConcurrentHashMap<>();
    private static final Map<String, String> hashMap = new HashMap<>();

    public static String intern(String s){
       String result = map.putIfAbsent(s, s); //与指定键相关联的先前值，如果该键没有映射关系，则返回 null。（如果该实现支持 null 值，则返回 null 还可以指示此映射以前曾将 null 与该键相关联）。
        return result == null?s:result; //String.intern 如果池里面有测，直接拿来，如果没有就先放到池里面，在拿出来
    }

    /**
     *先get，看看有没有必要调用putIfAbsent， 再掉putIfAbsent
     * @param s
     * @return
     */
    public static String internNew(String s){
        String result = map.get(s);
        if(result == null){
            result = map.putIfAbsent(s, s);
            if(result == null){
                result = s;
            }
        }
        return result;
    }
}
