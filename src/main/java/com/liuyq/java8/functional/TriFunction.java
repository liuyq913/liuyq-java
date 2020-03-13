package com.liuyq.java8.functional;

/**
 * @Auther: liuyuqing
 * @Date: 2020/3/8 22:33
 * @Description:
 */
public interface TriFunction<T, U, V, R> {
    R apply(T t, U u, V v);
}
