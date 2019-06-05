package com.liuyq.thread.thread72;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * Created by liuyq on 2019/3/8.
 */
public class WeakRefDemo {
    public static void main(String... args) {

        // all these objects have a strong reference
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();

        // other references to these objects
        Object strongA = a;  //只要强引用存在用于不会被回收，即使内存溢出
        SoftReference<Object> softB = new SoftReference<>(b); //软引用，当内存溢出之前，会吧这些对象收集起来，如果第二次回收还没有足够的内存，则回收他们
        WeakReference<Object> weakC = new WeakReference<>(c); //弱引用,第一次垃圾回收及被回收掉

        // free the former strong references to these objects:

        // there is still a strong reference(strongA) to the first object
        a = null;
        // only a soft reference(softB) refers to the second object
        b = null;
        // only a weak reference(weakC) refers to the third object
        c = null;

        System.out.println("Before gc...");
        System.out.println(String.format("strongA = %s, softB = %s, weakC = %s", strongA, softB.get(), weakC.get()));

        System.out.println("Run GC...");

        System.gc();

        // object with only soft reference will be cleaned only if memory is not enough: 用来做缓存很不错
        // object with only weak reference will be cleaned after a gc operation:
        System.out.println("After gc...");
        System.out.println(String.format("strongA = %s, softB = %s, weakC = %s", strongA, softB.get(), weakC.get()));
    }
}
