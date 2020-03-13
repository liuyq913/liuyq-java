package com.liuyq.java8.functional;

import java.util.function.Function;

/**
 * @Auther: liuyuqing
 * @Date: 2020/3/8 22:45
 * @Description:
 */
class One {}
class Two {}

public class ConsumeFunction {
    static Two consume(Function<One,Two> onetwo) {
        return onetwo.apply(new One());
    }
    public static void main(String[] args) {
        Two two = consume(one -> new Two());
    }
}
