package com.liuyq.thread.dahua;

/**
 * Created by liuyq on 2019/3/15.
 */
public class CurrentGetTotal extends Thread{

    private DissCar dissCar;


    public CurrentGetTotal(DissCar dissCar){
        this.dissCar = dissCar;
    }
    @Override
    public void run() {
        System.out.println("碟子总数："+dissCar.getTotolNum());
    }
}
