package com.liuyq.thread.thread70;

/**
 * Created by Administrator on 2018/4/9 0009.
 */
public class NoVisibility {
    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread{
        public void run(){
            while (!ready) Thread.yield();
            System.out.println(number);
        }
    }

    public static void main(String[] args){
        new ReaderThread().start();
        number = 47;
        ready = true;
    }
}
