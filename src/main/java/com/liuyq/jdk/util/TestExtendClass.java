package com.liuyq.jdk.util;

/**
 * Created by liuyq on 2018/3/15.
 */
public class TestExtendClass extends AbstractClass{
    private Integer i = 2;
    public TestExtendClass() {
        System.out.println();
    }

    private class test{
        private Integer u = i;
    }


    public static final void main(String[] args) {
        TestExtendClass testExtendClass = new TestExtendClass();
        System.out.println("hello world " + testExtendClass.getM());
        //new AbstractClass(); //同包下可以new
    }
}
