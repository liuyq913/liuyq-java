package com.liuyq.design.mediator;

/**
 * @author: liuyuqing
 * @Date: 2020/8/26 22:55
 */
public class ConcreteMediator extends Mediator {
    private ConcreteColleague1 colleague1;
    private ConcreteColleague2 colleague2;

    @Override
    public void send(String message, Colleague colleague) {
        if (colleague1 == colleague) {
            colleague2.notify(message);
        } else {
            colleague1.notify(message);
        }
    }

    public void setColleague1(ConcreteColleague1 colleague1) {
        this.colleague1 = colleague1;
    }

    public void setColleague2(ConcreteColleague2 colleague2) {
        this.colleague2 = colleague2;
    }
}
