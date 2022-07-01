package com.liuyq.jdk1216;

/**
 * @author liuyuqing
 * @className TextTest
 * @descriptionWun 文本块  jdk13
 * @date 2022/6/29 3:51 下午
 */
public class TextTest {

    public static void main(String[] agrs) {
        /**
         * 文本快，编译之后会跟之前的一样的
         */
        String str = """
                eqerqerj
                qewrjqeojroqiejwr
                ewrqkeroiqjewroiqerkqlekrnq
                ihweriqe
                """;

        System.out.println(str);
    }
}
