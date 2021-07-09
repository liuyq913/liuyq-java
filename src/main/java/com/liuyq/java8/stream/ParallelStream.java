package com.liuyq.java8.stream;

import java.util.stream.LongStream;

/**
 * @author liuyuqing
 * @className ParallelStream
 * @description 并行计算
 * @date 2021/5/25 10:21 上午
 */
public class ParallelStream {

    public static void main(String[] args){
        //并行计算
        long time= System.currentTimeMillis();
        long sum1 = LongStream.rangeClosed(1,100000000000l).parallel().sum();
        System.out.println(System.currentTimeMillis()-time);


    }
}
