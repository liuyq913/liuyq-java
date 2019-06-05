package com.liuyq.jdk.util;

import org.omg.PortableInterceptor.INACTIVE;

public class Test {

    public static void main(String[] agrs){
        String s1 = "a,b";
        String s2 = "a";
        String s3 = "b";
        String[] strings = s1.split(",");
        System.out.println(strings[0] == s2);
    }

}
