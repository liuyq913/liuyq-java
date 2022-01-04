package com.liuyq.design.lsp;

import java.util.HashMap;

/**
 * @author liuyuqing
 * @className Son
 * @description
 * @date 2021/12/23 3:55 下午
 */
public class Son extends Father {
    HashMap doSomething(HashMap map) {
        System.out.println("Son doSomething");
        return null;
    }


    public static  void main(String[] args) {
        HashMap map = new HashMap();
        Son son = new Son();
        son.doSomething(map);
    }
}
