package com.liuyq.java8.biconsumer;

import java.util.function.BiConsumer;

/**
 * @Auther: liuyuqing
 * @Date: 2020-01-03 16:24
 * @Description:
 */
public class TestBiConsumer {


    public void addToLoaded(BiConsumer<A, B> addMethod){
        A a = new B();
        B b = new B();
        addMethod.accept(a,b);
    }


    public void addToLoadedImp(){
        this.addToLoaded(Container::addLast);
    }

}
