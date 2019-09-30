package com.liuyq.java8;


import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Created by liuyq on 2019/6/24.
 */
public class TestSupplier {
    public static void main(String[] ahrs) {
        Map map = new HashMap();
        map.get(Optional.ofNullable(map.get("靶类")).orElse(0));
    }
}
