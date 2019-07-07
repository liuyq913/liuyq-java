package com.liuyq.java8;

/**
 * Created by liuyq on 2019/6/24.
 */
public class TestSupplier {
    public static void main(String[] ahrs){

    }

    public RestTemplateTest create(Car car){
        return restTemplate -> {
            System.out.println(234);
        };
    }
}
