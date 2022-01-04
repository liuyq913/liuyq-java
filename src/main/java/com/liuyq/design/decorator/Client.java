package com.liuyq.design.decorator;

/**
 * @author liuyuqing
 * @className Client
 * @description
 * @date 2021/12/30 3:30 下午
 */
public class Client {

    public static void main(String[] ahrs) {
        Component component = new Component();


        component = new Decorator1(component);

        component = new Decorator2(component);

        component.doSomeThing();

    }

}
