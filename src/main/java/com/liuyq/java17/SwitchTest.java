package com.liuyq.java17;

/**
 * @author liuyuqing
 * @className SwithTest
 * @description
 * @date 2022/6/22 10:28 上午
 */
public class SwitchTest {

    static enum SwitchEnums {
        MONDAY, TUESDAY, WEDNESDAY
    }

    static String formatterPatternSwitch(Object o) {
        return switch (o) {
            case Integer i -> String.format("int %d", i);
            case Long l -> String.format("long %d", l);
            case Double d -> String.format("double %f", d);
            case String s -> String.format("String %s", s);
            default -> o.toString();
        };
    }

    static void test_2(SwitchEnums enums) {
        switch (enums) {
            case MONDAY -> System.out.println("1");
            case TUESDAY -> System.out.println("2");
            case default -> System.out.println("12");
        }

    }

    public static void main(String[] agrs) {
        Integer i = 1;
        System.out.println(formatterPatternSwitch(i));
    }
}
