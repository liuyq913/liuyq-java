package com.liuyq.jvm;

/**
 * @author liuyuqing
 * @className MyRunnable
 * @description
 * @date 2022/7/8 4:25 下午
 */
public class MyRunnable implements Runnable {

    public void run() {
        methodOne();
    }

    public void methodOne() {
        int localVariable1 = 45;

        MySharedObject localVariable2 =
                MySharedObject.sharedInstance;

        //... do more with local variables.

        methodTwo();
    }

    public void methodTwo() {
        Integer localVariable1 = new Integer(99);

        //... do more with local variable.
    }
}

class MySharedObject {
    //static variable pointing to instance of MySharedObject

    public static final MySharedObject sharedInstance =
            new MySharedObject();


    //member variables pointing to two objects on the heap

    public Integer object2 = new Integer(22);
    public Integer object4 = new Integer(44);

    public long member1 = 12345;
    public long member2 = 67890;

    public static void main(String[] agrs){
        String str1 = new String("hello") + new String("world");
        str1.intern();
        String str2 = "helloworld";
        System.out.println(str1 == str2);//true
    }
}

