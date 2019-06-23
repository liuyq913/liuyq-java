package com.liuyq.java8;

/**
 * Created by liuyq on 2019/6/23.
 */
@FunctionalInterface
public interface Supplier<T> {
    T get();
}
