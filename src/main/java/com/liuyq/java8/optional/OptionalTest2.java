package com.liuyq.java8.optional;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * @Auther: liuyuqing
 * @Date: 2020/3/10 22:26
 * @Description:
 */
public class OptionalTest2 {
    static void basics(Optional<String> optString) {
        if (optString.isPresent()) //是否有值
            System.out.println(optString.get());
        else
            System.out.println("Nothing inside!");
    }

    static void ifPresent(Optional<String> optString) {
        optString.ifPresent(System.out::println); //存在则打印
    }

    static void orElse(Optional<String> optString) {
        System.out.println(optString.orElse("Nada"));  //如果值存在则直接返回，否则生成 nada。
    }

    static void orElseGet(Optional<String> optString) {
        System.out.println(
                optString.orElseGet(() -> "Generated"));////如果值存在则直接返回,否则生成生成一个可以替代的对象
    }

    static void orElseThrow(Optional<String> optString) {
        try {
            System.out.println(optString.orElseThrow( //没有值则抛异常
                    () -> new Exception("Supplied")));
        } catch (Exception e) {
            System.out.println("Caught " + e);
        }
    }

    static void test(String testName, Consumer<Optional<String>> cos) {
        System.out.println(" === " + testName + " === ");
        cos.accept(Stream.of("Epithets").findFirst());
        cos.accept(Stream.<String>empty().findFirst());
    }

    public static void main(String[] args) {
        test("basics", OptionalTest2::basics);
        test("ifPresent", OptionalTest2::ifPresent);
        test("orElse", OptionalTest2::orElse);
        test("orElseGet", OptionalTest2::orElseGet);
        test("orElseThrow", OptionalTest2::orElseThrow);
    }
}
