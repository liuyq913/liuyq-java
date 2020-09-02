package com.liuyq.design.mediator;

/**
 * 抽象同事
 *
 * @author: liuyuqing
 * @Date: 2020/8/26 22:51
 */
public abstract class Colleague {

    protected Mediator mediator;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }

    public void send(String message) {
        this.mediator.send(message, this);
    }

    public abstract void notify(String message);
}
