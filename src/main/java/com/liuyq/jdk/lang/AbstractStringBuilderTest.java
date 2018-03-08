package com.liuyq.jdk.lang;

import org.junit.Test;

/**
 * Created by liuyq on 2018/3/8.
 */
public class AbstractStringBuilderTest {
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    private char[] value;

    public AbstractStringBuilderTest(int lenght){
        value = new char[lenght];
    }
    @Test
    public void lengAndCapacity(){
        char[] c = new char[12];
        System.out.println(c.length);
        System.out.println(c);
        c[0] = '1';
        c[1] = '2';
        System.out.println(c.length);
    }
    public int newCapacity(int minCapacity) {
        // overflow-conscious code
        int newCapacity = (value.length << 1) + 2;
        if (newCapacity - minCapacity < 0) {
            newCapacity = minCapacity;
        }
        return (newCapacity <= 0 || MAX_ARRAY_SIZE - newCapacity < 0)
                ? hugeCapacity(minCapacity)
                : newCapacity;
    }

    private int hugeCapacity(int minCapacity) {
        if (Integer.MAX_VALUE - minCapacity < 0) { // overflow
            throw new OutOfMemoryError();
        }
        return (minCapacity > MAX_ARRAY_SIZE)
                ? minCapacity : MAX_ARRAY_SIZE;
    }
    public static void main(String[] agrs) {
        AbstractStringBuilderTest abstractStringBuilderTest = new AbstractStringBuilderTest(10);
        System.out.println(abstractStringBuilderTest.newCapacity(21));

    }
}
