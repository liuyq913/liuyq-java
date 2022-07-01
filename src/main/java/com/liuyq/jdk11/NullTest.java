package com.liuyq.jdk11;

/**
 * @author liuyuqing
 * @className NullTest
 * @description
 * @date 2022/6/29 4:03 下午
 */
public class NullTest {

    /**
     * because "s" is null 直接指出谁是空
     *
     * @param agrs
     */
    public static void main(String[] agrs) {
        test(null, null);
    }

    public static void test(String s, String b) {
        int length = s.length() + b.length();
        System.out.println(length);
    }
}
