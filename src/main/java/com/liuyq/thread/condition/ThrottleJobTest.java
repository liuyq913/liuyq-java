package com.liuyq.thread.condition;

import org.junit.Test;

public class ThrottleJobTest {

    @Test
    public void test() throws InterruptedException {
        ThrottleJob throttleJob = new ThrottleJob();
        throttleJob.submit();
        Thread.sleep(2000);
        throttleJob.signalAll();
    }

    @Test
    public void test2(){
        ThrottleJob throttleJob = new ThrottleJob();
        throttleJob.checkIsSameThread();

    }
}
