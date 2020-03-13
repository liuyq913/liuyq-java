package com.liuyq.java8.stream;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Auther: liuyuqing
 * @Date: 2020/3/10 22:42
 * @Description:
 */
public class StreamOfStreams {
    public static void main(String[] args) {
        Stream.of(1, 2, 3)
                .map(i -> Stream.of("Gonzo", "Kermit", "Beaker"))
                .map(e-> e.getClass().getName())
                .forEach(System.out::println);

    }
}
