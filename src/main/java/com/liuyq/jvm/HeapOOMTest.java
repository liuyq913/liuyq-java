package com.liuyq.jvm;

import java.util.LinkedList;

/**
 * Created by liuyq on 2019/9/29.
 */
public class HeapOOMTest {
    public static void main(String[] args){
        LinkedList<HeapOOMTest> l=new LinkedList<HeapOOMTest>();//作为GC Root
        while(true){
            l.add(new HeapOOMTest());//疯狂创建对象
        }
    }
}
