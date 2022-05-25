package com.liuyq.jdk.generics;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author liuyuqing
 * @className GenericTest
 * @description
 * @date 2022/3/18 2:17 下午
 */
public class GenericTest {

    public static void main(String[] ahrs) {
        List<? super Fruit> list = Lists.newArrayList();

        list.add(new Apple());

    }
}
