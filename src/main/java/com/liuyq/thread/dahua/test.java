package com.liuyq.thread.dahua;

/**
 * Created by liuyq on 2019/3/15.
 */
public class test {
    public static void main(String[] args) throws InterruptedException {
        DissCar dissCar  = new DissCar();
        CurrentSizeTest currentSizeTest = null;
        Object object  = new Object();

        for(int i =0;i<4; i++){
            currentSizeTest = new CurrentSizeTest(dissCar, object);
            currentSizeTest.start();
        }

        CurrentGetTotal currentGetTotal = new CurrentGetTotal(dissCar);
        currentSizeTest.join();
        currentGetTotal.start();
    }
}
