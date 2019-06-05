package com.liuyq.thread.join;

/**
 * Created by liuyq on 2019/2/27.
 */
public class JoinExample
{
    public static void main(String[] args) throws InterruptedException
    {
        Thread t = new Thread(new Runnable()
        {
            public void run()
            {
                System.out.println("First task started");
                System.out.println("Sleeping for 2 seconds");
                try
                {
                    Thread.sleep(2000);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                System.out.println("First task completed");
            }
        });
        Thread t1 = new Thread(new Runnable()
        {
            public void run()
            {
                System.out.println("Second task completed");
            }
        });
        t.start(); // Line 15
        t.join(); // Line 16  t执行完之后在执行后面
        t1.start();
    }
}