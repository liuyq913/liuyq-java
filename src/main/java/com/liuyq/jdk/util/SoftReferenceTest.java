package com.liuyq.jdk.util;

import java.lang.ref.SoftReference;

/**
 * Created by Administrator on 2018/3/29 0029.
 *
 *
 * SoftReference是强引用，他保存了对象实例，除非jvm即将OutOfMemory,否则不会被gc回收
 * 。这个特性使得它特别适合设计对象Cache。对于Cache，我们希望被缓存的对象最好始终常驻内存，
 * 但是如果JVM内存吃紧，为了不发生OutOfMemoryError导致系统崩溃，必要的时候也允许JVM回收Cache的内存，
 * 待后续合适的时机再把数据重新Load到Cache中。这样可以系统设计得更具弹性。
 *
 *
 *
 *
 *
 *
 *
 *
 *
 * SoftReference比WeakReference生命力更强，当JVM的内存不吃紧时，即使引用的对象被置为空了，Soft还可以保留对该对象的引用，此时的JVM内存池实际上还保有原来对象，只有当内存吃紧的情况下JVM才会清除Soft的引用对象，并且会在未来重新加载该引用的对象。

 而WeakReference则当清理内存池时会自动清理掉引用的对象。
 */
public class SoftReferenceTest {
    /**
     * @param args
     */
    public static void main(String[] args) {
        A a = new A();
        a.str = "Hello, reference";
        SoftReference<A> sr = new SoftReference<A>(a);
        a = null;
        int i = 0;
        while (sr.get() != null) {
            System.out.println(String.format("Get str from object of SoftReference: %s, count: %d", sr.get().str, ++i));
            if (i % 10 == 0) {
                System.gc();
                System.out.println("System.gc() was invoked!");
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {

            }
        }
        System.out.println("object a was cleared by JVM!");
    }
}
