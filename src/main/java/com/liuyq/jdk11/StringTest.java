package com.liuyq.jdk11;

/**
 * @author liuyuqing
 * @className StringTest
 * @description
 * @date 2022/6/23 5:08 下午
 */
public class StringTest {

    public static void main(String[] args) {
        String s = "\t\n ";
        System.out.println(s.isBlank());

        // 去除首位空白
        String s1 = "\t\n  -----  \t\n ";
        System.out.println(s1.strip());
        //去头
        System.out.println(s1.stripTrailing());
        // 去尾
        System.out.println(s1.stripLeading());

        System.out.println(s1.lines().count());
    }
}
