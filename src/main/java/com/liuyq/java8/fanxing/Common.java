package com.liuyq.java8.fanxing;

import java.util.List;

/**
 * Created by liuyq on 2019/8/3.
 */
public class Common<T> {

    private List<T> list;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public void print() {
        System.out.println(list.size());
    }
}
