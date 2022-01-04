package com.liuyq.design.decorator;

/**
 * @author liuyuqing
 * @className Decorator1
 * @description
 * @date 2021/12/30 3:21 下午
 */
public class Decorator1 extends Decorator {

    public Decorator1(Component component) {
        super(component);
    }

    public void doSomeThing1(){
        System.out.println("包装器1， doSomeThing1");
    }
}
