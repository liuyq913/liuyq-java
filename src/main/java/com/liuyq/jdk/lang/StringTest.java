package com.liuyq.jdk.lang;

import org.junit.Test;

/**
 * Created by liuyq on 2018/3/2.
 */
public class StringTest {
    @Test
    public void hashTest(){
        System.out.println("123".hashCode());
    }
    @Test
    public void test(){
        String s = new String(new int[]{122322,122322,122322,122322},0,3);
        System.out.println(s);
    }
    @Test
    public void testCodePointAt(){
        String s = "1!34";
        System.out.println(s.charAt(1));
        //返回对应char的ASCII码10进制数
        System.out.println(s.codePointAt(1));
        //返回index前面一位的char的ASCII的10进制数
        System.out.println(s.codePointBefore(1));
    }

    @Test
    public void testCompareTo(){
        String s = "12";
        System.out.println(s.compareTo("12"));
    }

    @Test
    public void testCompareToIgnoreCase(){
        String s = "AB";
        System.out.println(s.compareToIgnoreCase("B"));
    }
    @Test
    public void testCharAt(){
        String s = "A";
        char a = s.charAt(0);
        System.out.println(a);
    }
    @Test
    public void testIndexOf(){
        String s = "hello world";
        System.out.println(s.indexOf("w",4)); //当目标字符串是空串的时候，直接返回开始索引的值
       // System.out.println(s.indexOf("",-1)); //当开始索引值小于0的时候，返回0

    }
}
