package com.liuyq.jdk9;

import java.io.IOException;

/**
 * @author liuyuqing
 * @className ProcessHandleTest
 * @description
 * @date 2022/6/22 3:02 下午
 */
public class ProcessHandleTest {

    public static void main(String[] agrs) throws IOException {

        final ProcessBuilder processBuilder = new ProcessBuilder("top")
                .inheritIO();
        final ProcessHandle processHandle = processBuilder.start().toHandle();
        processHandle.onExit().whenCompleteAsync((handle, throwable) -> {
            if (throwable == null) {
                System.out.println(handle.pid());
            } else {
                throwable.printStackTrace();
            }
        });

    }
}
