package com.liuyq.java8.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Auther: liuyuqing
 * @Date: 2020/3/10 22:43
 * @Description:
 */
public class FlatMap {
    public static void main(String[] args) {
        List<String> list = Stream.of(1, 2, 3)
                .flatMap(i -> Stream.of(i.toString(), "Fozzie"))
                .collect(Collectors.toList());
        System.out.println(list);

        Stream.of(1, 2, 3)
                .flatMap(i -> Stream.of(i.toString(), "Fozzie"))
                .forEach(System.out::println);
    }
}
