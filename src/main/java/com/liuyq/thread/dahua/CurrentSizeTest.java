package com.liuyq.thread.dahua;

/**
 * Created by liuyq on 2019/3/15.
 */
public class CurrentSizeTest extends Thread{

    public volatile DissCar dissCar;

    public Object obj;


    public CurrentSizeTest(DissCar dissCar, Object obj){
        this.dissCar = dissCar;
        this.obj = obj;
    }

    @Override
    public void run() {
        Integer num = dissCar.getCurrentNum();
        System.out.println("生产"+num);
      //  synchronized (obj) {
            dissCar.setNum(num);
      //  }
        System.out.println("当前碟子总数"+dissCar.getTotolNum());
    }
}
