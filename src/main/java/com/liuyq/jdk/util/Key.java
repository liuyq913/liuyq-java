package com.liuyq.jdk.util;

/**
 * Created by liuyq on 2018/3/26.
 */
public class Key implements Comparable<Key>{
    private final int value;

    public static final int MAX_KEY = 10_000_000;
    private static final Key[] KEYS_CACHE = new Key[MAX_KEY];

    static {
        for(int i = 0; i<MAX_KEY; ++i){
            KEYS_CACHE[i] = new Key(i);
        }
    }
    Key(int value){
        this.value = value;
    }

    @Override
    public int compareTo(Key o) {
        return Integer.compare(this.value, o.value);
    }

    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null ||  getClass() != o.getClass()) return false;
        Key key = (Key)o;
        return key.value == this.value;
    }

    public int hashCode(){
        return value;
    }



}
