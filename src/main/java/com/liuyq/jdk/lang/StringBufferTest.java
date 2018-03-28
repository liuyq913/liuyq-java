package com.liuyq.jdk.lang;

import org.junit.Test;

/**
 * Created by liuyq on 2018/3/13.
 */
public class StringBufferTest {
    @Test
    public void test(){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ACB");
        String s = stringBuffer.toString();
        System.out.println(s);
    }
}
