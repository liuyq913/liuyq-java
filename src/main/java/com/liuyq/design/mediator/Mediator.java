package com.liuyq.design.mediator;

/**
 * 抽象中介者
 * @author: liuyuqing
 * @Date: 2020/8/26 22:50
 */
public abstract class Mediator {

    public abstract void send(String message, Colleague colleague);
}
