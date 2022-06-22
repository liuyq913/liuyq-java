package com.liuyq.jdk9;

/**
 * @author liuyuqing
 * @className interafcesTest
 * @description
 * @date 2022/6/22 4:25 下午
 */
public interface interfaceTest {

    void test_1();

    default void test_2() {
        return;
    }


    static void test_3() {

    }


    //jdk9 之后接口里面可以有私有方法
    private void test_4() {

    }


}
