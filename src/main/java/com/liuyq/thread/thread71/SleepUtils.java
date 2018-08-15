package com.liuyq.thread.thread71;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2018/7/31 0031.
 */
public class SleepUtils {
    public static final void second(long second) {
        try {
            TimeUnit.SECONDS.sleep(second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
