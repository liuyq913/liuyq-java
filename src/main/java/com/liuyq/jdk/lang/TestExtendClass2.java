package com.liuyq.jdk.lang;

import com.liuyq.jdk.util.AbstractClass;
import com.liuyq.jdk.util.TestExtendClass;

/**
 * Created by liuyq on 2018/3/15.
 */
public class TestExtendClass2 extends AbstractClass{
    public TestExtendClass2() {
         //super(12);
    }


    public static final void main(String[] args) {
        TestExtendClass testExtendClass = new TestExtendClass();
        System.out.println("hello world " + testExtendClass.getM());
       // new AbstractClass();不同的下不能new  protected
    }
}
