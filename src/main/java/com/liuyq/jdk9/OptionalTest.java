package com.liuyq.jdk9;

import java.util.Optional;

/**
 * @author liuyuqing
 * @className OptionalTest
 * @description
 * @date 2022/6/22 5:41 下午
 */
public class OptionalTest {
    public static void main(String[] agrs) {
        String s = null;

        String s2 = Optional.ofNullable(s).orElse("12");
        System.out.println(s2);

        Optional.ofNullable(s).or(() -> Optional.of("AA")).ifPresent(t -> System.out.println(t));
    }
}
