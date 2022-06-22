package com.liuyq.java17;

import java.util.Random;
import java.util.random.RandomGenerator;

/**
 * @author liuyuqing
 * @className RandomTest
 * @description
 * @date 2022/6/21 5:06 下午
 */
public class RandomTest {

    public static String getRandomString(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    public static void jdk17Random() {
        RandomGenerator g = RandomGenerator.of("Random");

        System.out.println(g.nextInt(100));
    }

    public static void main(String[] ahrs) {

        Random random = new Random(10);
        for (int i = 0; i < 10; i++) {
            System.out.println(random.nextInt(10));
        }


        System.out.println("-----------------------");


        for (int i = 0; i < 10; i++) {
            System.out.println(random.nextInt(10));
        }
    }
}
