package com.liuyq.design.mediator;

/**
 * @author: liuyuqing
 * @Date: 2020/8/26 22:55
 */
public class ConcreteColleague1 extends Colleague{

    public ConcreteColleague1(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void notify(String message) {
        System.out.println("同事1收到消息：" + message);
    }
}
