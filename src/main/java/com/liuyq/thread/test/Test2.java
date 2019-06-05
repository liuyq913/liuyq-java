package com.liuyq.thread.test;

/**
 * Created by liuyq on 2018/12/27.
 */
public class Test2 {
    public static  void main(String[] agrs){
        String s1 = "helloworld";
        final String s2 = "hello";
        String s3 = "hello";
        String s4 = s2 + "world";
        String s5 = s3 + "world";
        System.out.println(s1 == s4); //true
        System.out.println(s1 == s5); //flase

        String a = new String("helloworld");
        final String b = new String("hello");
        String c = new String("hello");
        String d = b + "world";
        String e = c + "world";
        System.out.println(a == d); //false
        System.out.println(a == e); //flase
    }
}
