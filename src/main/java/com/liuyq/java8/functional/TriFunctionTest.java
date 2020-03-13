package com.liuyq.java8.functional;

/**
 * @Auther: liuyuqing
 * @Date: 2020/3/8 22:33
 * @Description:
 */
public class TriFunctionTest {
    static int f(int i, long l, double d) {
        return 99;
    }

    public static void main(String[] args) {
        TriFunction<Integer, Long, Double, Integer> tf =
                TriFunctionTest::f;
        tf = (i, l, d) -> 12;

        System.out.println(tf.apply(12, 0l, 2d));

    }
}
