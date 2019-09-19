package com.liuyq.java8.reduce;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by liuyq on 2019/9/19.
 */
public class ReduceTest {
    public static void main(String[] args) {
        Stream<Integer> stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8});
        Integer sum = stream.reduce(0, Integer::sum); //求和
        System.out.println(sum);

        stream.reduce((i, j) -> i + j).ifPresent(System.out::println); //qi

        stream.reduce(Integer::max).ifPresent(System.out::println);

    }

}
