package com.liuyq.java8.optional;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

/**
 * Created by liuyq on 2019/8/13.
 */
public class OptionalTest {

    @Test
    public void test1() {
        //要明确输入值不为null，否则会抛空指针异常
        Optional<User> opt = Optional.of(null);
    }

    @Test
    public void test2() {
        List<User> list = Lists.newArrayList();

        for (Integer i = 0; i < 10; i++) {
            User user = new User();
            user.setId(i);
            user.setUser("liuyq");
            list.add(user);
            list.add(null);
        }
    }

    @Test
    public void test3(){
        for(;;){
            System.out.println(1);
        }
    }
}
