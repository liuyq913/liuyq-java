package com.liuyq.thread.test;

/**
 * Created by liuyq on 2018/11/14.
 */
public class DubboTest {
    public static void main(String[] agrs) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Class clazz =  Class.forName("com.liuyq.thread.test.DoubleUtil", true, classLoader);
        //System.out.println(clazz);
        DoubleUtil doubleUtil = (DoubleUtil) clazz.newInstance();
        System.out.println(clazz.getName());
        System.out.println(clazz.getMethods().length);
        System.out.println(clazz.getMethods()[1]);
    }
}
