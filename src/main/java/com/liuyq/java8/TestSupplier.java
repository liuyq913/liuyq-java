package com.liuyq.java8;


import com.google.common.collect.Lists;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by liuyq on 2019/6/24.
 */
public class TestSupplier {
    public static void main(String[] ahrs) {
        List<String> s = Lists.newArrayList();
        s.add("1");
        s.add(null);
        s  = s.stream().filter(t->t!=null).collect(Collectors.toList());

        System.out.println(s);
    }
}
