package com.liuyq.structure.queue;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by liuyq on 2019/6/6.
 */
public class Demo {
    public static void main(String[] hars){
        List<Model> list = Lists.newArrayList();
        Model model = new Model();
        for(Integer i =0 ;i<3;i++){
            model.setA(i);
            model.setB(i);
            list.add(model);
        }
        System.out.println(JSON.toJSON(list));
    }
}
