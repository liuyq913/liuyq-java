package com.liuyq.design.decorator;

/**
 * @author liuyuqing
 * @className Decorator
 * @description
 * @date 2021/12/30 3:17 下午
 */
public abstract class Decorator extends Component {

    private Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    public void doSomeThing() {
        this.doSomeThing1();
        component.doSomeThing();
    }

    public void doSomeThing1(){

    }
}
