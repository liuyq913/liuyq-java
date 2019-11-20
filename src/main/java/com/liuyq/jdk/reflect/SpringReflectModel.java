package com.liuyq.jdk.reflect;

import com.google.common.collect.Lists;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.Constructor;
import java.util.List;

public class SpringReflectModel {

    private List<String> stringList = Lists.newArrayList("1","2");


    /**
     * @see org.springframework.beans.BeanUtils#instantiateClass
     * @throws NoSuchMethodException
     */
    @Test
    public void test3() throws NoSuchMethodException {
        Constructor<?> constructor = SpringReflectModel2.class.getDeclaredConstructor(SpringReflectModel.class);
        Object instance = BeanUtils.instantiateClass(constructor, new Object[]{this}); //这里通过构造方法反射 ，会调用到构造方法，产值为this,springboot 构造多播器就是这样到
    }
}
