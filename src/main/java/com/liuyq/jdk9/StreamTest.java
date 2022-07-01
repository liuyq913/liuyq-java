package com.liuyq.jdk9;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author liuyuqing
 * @className StreamTest
 * @description
 * @date 2022/6/22 1:32 下午
 */
public class StreamTest {

    public static class Person implements Serializable {
        private Integer age;
        private String name;


        public Person(Integer age, String name) {
            this.age = age;
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public void list() {
        List<String> list = List.of("1", "2", "3");

        System.out.println(list);

        // 不能在操作
        list.add("23");

        System.out.println(list);
    }

    public void set() {

        Set set = Set.of(1, 2, 2, 2);

        System.out.println(set);
    }


    public static void stream_iterator() {
        Iterator iterator = Stream.of(1, 2, 3, 23, 23, 2, 2, 2, 2, 2, 3, 3).iterator();

        for (; ; ) {
            if (iterator.hasNext()) {
                System.out.println(iterator.next());
            } else {
                break;
            }
        }
    }

    public static void stream_ofNullable() {
        List<Object> strings = Stream.ofNullable(null).toList();
        System.out.println(strings);
    }


    public static void stream_dropWhile() {
        // dropWhile 删除 除于2不等于0的，直到除于2=0停止，然后输出
        List<Integer> list = Stream.of(1, 2, 3, 4, 5).dropWhile(i -> i % 2 != 0).toList();
        System.out.println(list);

        List<Integer> list2 = Stream.of(1, 2, 3, 4, 5).filter(i -> i % 2 != 0).toList();
        System.out.println(list2);
    }


    public static void stream_takeWhile() {
        List<Integer> list = Stream.of(1, 2, 3, 4, 5).dropWhile(i -> i % 2 != 0).toList();
        System.out.println(list);
    }

    public static void stream_tableWhile() {
        // takeWhile 遇到 i % 2 != 0 就停止
        List<Integer> list = Stream.of(2, 3, 23, 23, 2, 2, 2, 2, 2, 3, 3).takeWhile(i -> i % 2 == 0).toList();
        System.out.println(list);
    }


    public static void stream_flatMapping() {

        final Set<Integer> result = Stream.of("a", "ab", "abc")
                .collect(Collectors.flatMapping(v -> v.chars().boxed(),
                        Collectors.toSet()));

        System.out.println(result);


        List<String> result2 = Stream.of(new Person(1, "liuyq"))
                .collect(Collectors.flatMapping(v -> Stream.of(String.valueOf(v.age), String.valueOf(v.name)), Collectors.toList()));

        System.out.println(result2);
    }

    public static void main(String[] args) {
        //stream_iterator();

        //stream_dropWhile();


        //  stream_tableWhile();

        stream_flatMapping();
    }
}
