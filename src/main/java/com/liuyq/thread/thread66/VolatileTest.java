package com.liuyq.thread.thread66;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by liuyq on 2018/2/28.
 * volatile修饰符不执行互斥访问，但它可以保证任何一个线程在读取该域的时候都将看到最近刚刚被写入的值
 */
public class VolatileTest {
   /* private static volatile int nextSerialNumber = 0 ;

    public static int generateSerialNumber(){
      return  nextSerialNumber++; //这个地方不是原子操作，分读 和 写存在安全隐患
    }*/

   private static final AtomicInteger nextSerialNumber = new AtomicInteger();

   public static long generateSerialNumber(){
      return nextSerialNumber.getAndIncrement();
   }
}
