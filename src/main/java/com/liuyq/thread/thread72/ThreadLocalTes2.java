package com.liuyq.thread.thread72;

/**
 * Created by liuyq on 2019/3/8.
 */
public class ThreadLocalTes2 {
    static class ResourceClass {

        public final static ThreadLocal<String> RESOURCE_1 =
                new ThreadLocal<String>();

    }

    static class A {
        public void setOne(String value) {
            ThreadLocalTest.ResourceClass.RESOURCE_1.set(value);
            ThreadLocalTest.ResourceClass.RESOURCE_1.set(value + value);
        }
    }

    static class B {
        public void display() {
            System.out.println(ThreadLocalTest.ResourceClass.RESOURCE_1.get());
        }
    }

    public static void main(String[] agrs) {
        final A a = new A();
        final B b = new B();
        for (int i = 0; i < 1; i++) {
            final String resouce1 = "线程-" + i;
            new Thread() {
                @Override
                public void run() {
                    try {
                        a.setOne(resouce1);
                        b.display();
                    } finally {

                    }
                }
            }.start();
        }
    }
}
