package com.liuyq.proxy;

/**
 * Created by Administrator on 2018/3/27 0027.
 */
public class RealSubject implements Subject{
    public String SayHello(String name) {
      return "hello " + name;
    }

    public String SayGoodBye() {
        return " good bye ";
    }
}
