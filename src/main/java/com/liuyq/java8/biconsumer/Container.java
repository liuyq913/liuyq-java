package com.liuyq.java8.biconsumer;


import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Auther: liuyuqing
 * @Date: 2020-01-03 16:36
 * @Description:
 */
public class Container {

    private static List<A<?>> list = new CopyOnWriteArrayList<>();

    public static void addLast(A<?> a, A<?> b) {
        list.add(a);
    }

    public void testType()throws IOException {
        try(TestClose t = new TestClose()){ //要继承closeAble才可以写在try 里面，会自动close，但是close的异常要抛出去

        }catch (Exception e){}
    }
}
