package com.liuyq.java8.functional;

import com.google.common.collect.Lists;

import java.util.Optional;
import java.util.function.Function;

/**
 * @Auther: liuyuqing
 * @Date: 2020/3/10 22:00
 * @Description:
 */
public class Curry3Args {
    public static void main(String[] args) throws Exception {
        Function<String,
                Function<String,
                        Function<String, String>>> sum =
                a -> b -> c -> a + b + c;
        Function<String,
                Function<String, String>> hi =
                sum.apply("Hi ");
        Function<String, String> ho =
                hi.apply("Ho ");
        System.out.println(ho.apply("Hup"));


        Optional.ofNullable(Lists.newArrayList()).orElseThrow(() -> new Exception("Supplied"));
    }

}
