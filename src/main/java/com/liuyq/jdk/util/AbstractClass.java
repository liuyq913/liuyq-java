package com.liuyq.jdk.util;

/**
 * Created by liuyq on 2018/3/15.
 */
public abstract class AbstractClass {
    private int m;
    protected AbstractClass() {
        System.out.println("父类构造");
    }
    protected AbstractClass(int n) {
        m = n;
    }
    public int getM() {
        return m;
    }
    public void setM(int m) {
        this.m = m;
    }
}
