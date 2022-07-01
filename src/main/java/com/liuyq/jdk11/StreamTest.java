package com.liuyq.jdk11;

import java.util.function.Consumer;

/**
 * @author liuyuqing
 * @className StreamTest
 * @description
 * @date 2022/6/29 3:12 下午
 */
public class StreamTest {
    public static void main(String[] args) {
        // 新增类型推断
        Consumer<String> s = (var a) -> {
            a.length();
        };
    }
}
