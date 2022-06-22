package com.liuyq.jdk9;

import java.io.InputStreamReader;

/**
 * @author liuyuqing
 * @className TryTest
 * @description
 * @date 2022/6/22 4:38 下午
 */
public class TryTest {

    public void jdk8() {
        // 资源自动关闭
        try (InputStreamReader reader = new InputStreamReader(System.in)) {

        } catch (Exception e) {
        }
    }


    public void jdk9() {
        InputStreamReader reader = new InputStreamReader(System.in);
        try (reader) {

        } catch (Exception e) {

        }
    }
}
