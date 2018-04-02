package com.liuyq.jdk.util;

import java.lang.ref.WeakReference;

/**
 * Created by Administrator on 2018/3/29 0029.
 *
 * WeaKReference是弱引用，其中保存的对象实例可以被GC回收掉，这个类通常用于
 * 保存对象引用而又不干扰该对象被GC回收，通常用于Debug、内存监视工具等程序中。
 * 因为这类程序一般要求即要观察到对象，又不能影响该对象正常的GC过程。
 */
public class WeakReaferenceTest {
    public static void main(String[] agrs){
        A a = new A();
        a.str = "Hello, reference";
        WeakReference<A> weak = new WeakReference<A>(a);
        a = null ;
        int i = 0;
        while(weak.get()!=null){
            System.out.println(String.format("Get str from object of WeakReference: %s, count: %d", weak.get().str, ++i));
            if(i % 10 == 0 ){
                System.gc();
                System.out.println("System.gc() was invoked!");
            }
            try{
                Thread.sleep(500);
            }catch (InterruptedException e){}
        }
        System.out.println("object a was cleared by JVM!");
    }
}
