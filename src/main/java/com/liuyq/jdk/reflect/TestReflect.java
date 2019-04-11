package com.liuyq.jdk.reflect;

/**
 * Created by liuyq on 2019/4/11.
 */
public class TestReflect {

  @org.junit.Test
    public void test(){
        BaseModel baseModel = new BaseModel();
        System.out.println(baseModel.reqParamsCheck(baseModel.getCheckParam()));
    }
}
