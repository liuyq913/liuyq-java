package com.liuyq.utils;

import java.util.function.Predicate;

public class OptionalUtils {
    public static <T> T filter(T t, Predicate<T> predicate) {
        return predicate.test(t) ? t : null;
    }

    public static <T> T filter(T t, Predicate<T>... predicate) {
        for (Predicate<T> p : predicate) {
            if (!p.test(t)) {
                return null;
            }
        }
        return t;
    }
}
