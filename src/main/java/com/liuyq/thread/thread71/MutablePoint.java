package com.liuyq.thread.thread71;

/**
 * Created by Administrator on 2018/4/18 0018.
 */
//非线程安全
public class MutablePoint {
    public  int x,y;

    public MutablePoint(){x = 0;y=0;}

    public MutablePoint(MutablePoint p){
        this.x = p.x;
        this.y = p.y;
    }
}
