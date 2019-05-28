package com.liuyq.jdk.reflect;

import org.junit.Test;

/**
 * Created by liuyq on 2019/4/11.
 */
public class TestReflect {

  @org.junit.Test
    public void test(){
        BaseModel baseModel = new BaseModel();
        System.out.println(baseModel.reqParamsCheck(baseModel.getCheckParam()));
    }

    @Test
    public void test1(){
        String s = "4wergaertertwer";
        int firstIndex = s.indexOf(42);
        System.out.println(firstIndex);
    }

    @Test
    public void test2(){
        String s = "123";
        System.out.println(s.matches("[0-9]*"));
    }
}
