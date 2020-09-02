package com.liuyq.design.mediator;

/**
 * @author: liuyuqing
 * @Date: 2020/8/26 22:58
 */
public class ConcreteColleague2 extends Colleague {

    public ConcreteColleague2(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void notify(String message) {
        System.out.println("同事2收到消息：" + message);
    }
}
