package com.liuyq.jvm;

/**
 * @author liuyuqing
 * @className SingleTon
 * @description
 * @date 2022/3/18 11:38 上午
 */
public class SingleTon {
    private static SingleTon singleTon = new SingleTon();

    private Main main = new Main();
    public static int count1;
    public static int count2 = 0;

    private SingleTon() {
        count1++;
        count2++;
    }

    public static SingleTon getInstance() {
        return singleTon;
    }

    public static void main(String[] agrs) {
        //SingleTon singleTon = SingleTon.getInstance();
        SingleTon singleTon1 = new SingleTon();
      //  System.out.println("count1=" + singleTon.count1);
       // System.out.println("count2=" + singleTon.count2);
    }
}
