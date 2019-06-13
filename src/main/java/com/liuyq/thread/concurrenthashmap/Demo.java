package com.liuyq.thread.concurrenthashmap;

/**
 * Created by liuyq on 2019/6/5.
 */
public class Demo {
    public static void main(String[] arsg) throws InterruptedException {
        CacheBuilderTest cacheBuilderTest = new CacheBuilderTest();

        cacheBuilderTest.overriddenInstanceStatusMap.put("1",1);
        System.out.println("休眠之前的值"+cacheBuilderTest.overriddenInstanceStatusMap.get("1"));
        Thread.sleep(4000);
        System.out.println("休眠之后的值"+cacheBuilderTest.overriddenInstanceStatusMap.get("1"));
    }
}
