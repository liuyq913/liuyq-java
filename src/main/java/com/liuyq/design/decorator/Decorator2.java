package com.liuyq.design.decorator;

/**
 * @author liuyuqing
 * @className Decorator2
 * @description
 * @date 2021/12/30 3:24 下午
 */
public class Decorator2 extends Decorator {

    public Decorator2(Component component) {
        super(component);
    }

    public void doSomeThing1() {
        System.out.println("包装器2， doSomeThing1");
    }
}
