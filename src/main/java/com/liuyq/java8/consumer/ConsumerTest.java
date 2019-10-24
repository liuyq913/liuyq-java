package com.liuyq.java8.consumer;

import com.google.common.collect.Lists;
import org.omg.CORBA.INTERNAL;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerTest {
    List<Integer> successlist = Lists.newArrayList();
    List<Integer> errorlist = Lists.newArrayList();

    public void doSomeing(Integer a) throws Exception {
        if (a == 1) throw new Exception("error in a");
        System.out.println(a);
    }

    public void batchDoSomeing(List<Integer> lists) {
        this.batchDoSomeing(lists, success -> {
            successlist.add(success);
        }, error -> {
            errorlist.add(error);
        });

    }

    public void batchDoSomeing(List<Integer> list, Consumer<Integer> success, Consumer<Integer> error) {
        list.stream().forEach(t->{
            try {
                doSomeing(t);
                success.accept(t);
            } catch (Exception e) {
                error.accept(t);
                e.printStackTrace();
            }
        });
    }

    public static void main(String[] agrs){
        ConsumerTest consumerTest = new ConsumerTest();

        List<Integer> list = Arrays.asList(new Integer[]{1,3,4,5,2,3});
        consumerTest.batchDoSomeing(list);
        consumerTest.errorlist.size();
    }
}
