package com.liuyq.java8.functional;

import java.util.function.Function;

/**
 * @Auther: liuyuqing
 * @Date: 2020/3/9 22:50
 * @Description:
 */
public class FunctionComposition {
    static Function<String, String>
            f1 = s -> {
        System.out.println(s);
        return s.replace('A', '_');
    },
            f2 = s -> s.substring(3),
            f3 = s -> s.toLowerCase(),
            f4 = f1.compose(f2).andThen(f3);
    public static void main(String[] args) {
        System.out.println(
                f4.apply("GO AFTER ALL AMBULANCES"));
    }
}
