package com.liuyq.thread.dahua;

import java.util.Random;

/**
 * Created by liuyq on 2019/3/15.
 */
public class DissCar {

    private Integer totolNum = 0;

    public Integer getCurrentNum(){
        return new Random().nextInt(10);
    }

    public void setNum(Integer num){
        totolNum += num;
    }

    public Integer getTotolNum(){
        return totolNum;
    }

}
