package com.liuyq.jvm;

import org.openjdk.jol.info.ClassLayout;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author liuyuqing
 * @className ObjectTest
 * @description
 * @date 2022/7/8 11:33 上午
 */
public class ObjectTest {
    public static void main(String[] agrs) {
        A a = new A("test", 10);
        a.makeDataToMap();

        ClassLayout aLayout = ClassLayout.parseInstance(a);
        System.out.println(aLayout.toPrintable());
    }


    static class A {
        private String name;
        private int age;
        Map<String, Object> map = new LinkedHashMap<String, Object>();

        public A(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public void makeDataToMap() {
            map.put("din", "ddddd");
            map.put("double", 90d);
        }

    }


}

