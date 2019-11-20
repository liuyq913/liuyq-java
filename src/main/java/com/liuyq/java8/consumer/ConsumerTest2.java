package com.liuyq.java8.consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerTest2 {


    void doSomeIng(Consumer<Integer> consumer, List<Integer> list) {
        for (Integer i : list){
            consumer.accept(i);
        }
    }

    void now(){
        doSomeIng(t->{
            System.out.println(t);
        }, Arrays.asList(1,2,34));
    }

    public static void main(String[] args){
        ConsumerTest2 consumerTest2 = new ConsumerTest2();
        consumerTest2.now();
    }
}
