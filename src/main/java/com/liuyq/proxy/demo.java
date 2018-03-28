package com.liuyq.proxy;

import javafx.scene.SubScene;

import java.lang.reflect.Proxy;

/**
 * Created by Administrator on 2018/3/27 0027.
 */
public class demo {
    public static void main(String[] args){
        Subject subject = new RealSubject();

        InvocationHandlerImpl invocationHandler = new InvocationHandlerImpl(subject);
        //对应类的类加载器。
        ClassLoader loader = subject.getClass().getClassLoader();
        Class[] infer = subject.getClass().getInterfaces();

        //该方法指定，类加载器，
        Subject subject1 = (Subject) Proxy.newProxyInstance(loader, infer, invocationHandler);

        String hello = subject1.SayHello("jiankunking");
        System.out.println(hello);

    }
}
