package com.liuyq.jdk1216;

/**
 * @author liuyuqing
 * @className RecordTest
 * @description
 * @date 2022/6/29 4:16 下午
 */
public class RecordTest {

    public static void main(String[] ahrs){
        Account account = new Account("122","123");
        System.out.println(account.toString());

    }

    // 记录类型  会自动生成get 方法构造方法
    public static record Account(String username, String password) {
    }
}
