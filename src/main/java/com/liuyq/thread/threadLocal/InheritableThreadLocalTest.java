package com.liuyq.thread.threadLocal;

/**
 * Created by liuyq on 2019/9/6.
 */
public class InheritableThreadLocalTest {

    /**
     *  new ThreadLocl  主线程设置了值，子线程是无法获取到值的
     *
     *  new InheritableThreadLocal 则可以
     */
    static ThreadLocal<Integer> threadLocal = new InheritableThreadLocal<Integer>();

    public static void main(String[] agrs){
        threadLocal.set(1000); //主线程设置

        new Thread(() -> {
            System.out.println("-----"+threadLocal.get());
        }).start();
    }
}
