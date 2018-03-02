package com.liuyq.jdk.lang;

import org.junit.Test;

/**
 * Created by liuyq on 2018/3/1.
 */
public class IntegerTest {

    int low = -123;

    final static int [] sizeTable = { 9, 99, 999, 9999, 99999, 999999, 9999999,
            99999999, 999999999, Integer.MAX_VALUE };

    static int stringSize(int x) {
        for (int i=0; ; i++)
            if (x <= sizeTable[i])
                return i+1;
    }

    @Test
    public void StringTest(){
        Integer integer = Integer.MIN_VALUE;
        System.out.println(integer.toString(integer, 10));
    }
    @Test
    public void stringSizeTest(){
        System.out.println(stringSize(123));
    }

    @Test
    public void charAtTest(){
        System.out.println("123".charAt(0));
    }

    @Test
    public void decodeTest(){
        System.out.println(Integer.decode("10"));
    }
    @Test
    public void valueofTest(){
        //System.out.println(Integer.valueOf(10));
        System.out.println(-low);
    }
    @Test
    public void hashCodeTest(){
        System.out.println(Integer.hashCode(112));
    }
}
