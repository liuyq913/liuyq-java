package com.liuyq.thread.consumerandproduct;

/**
 * Created by liuyq on 2019/2/27.
 */
public class Singleton {

    private Singleton(){};

    static Singleton getInstance(){
        return InnerSingleton.singleton;
    }

    static class InnerSingleton{
       static Singleton singleton = new Singleton();
    }
}
