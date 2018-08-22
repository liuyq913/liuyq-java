package com.liuyq.thread.thread73;

import java.sql.Connection;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Administrator on 2018/8/20 0020.
 */
public class ConnectionPoolTest {
    static ConnectionPool pool = new ConnectionPool(10);
    //保证所有的ConnectionRunner能同时开始
    static CountDownLatch start = new CountDownLatch(1);
    //main方法在所有ConnectionRunner结束后才会继续执行
    static CountDownLatch end;

    public static void main(String[] args) throws Exception {
        int threadCount = 10;
        end = new CountDownLatch(threadCount);
        int count = 20;
        AtomicInteger got = new AtomicInteger();
        AtomicInteger nogot = new AtomicInteger();
        for(int  i=0;i<threadCount;i++){
            Thread thread = new Thread(new ConnetionRunner(count, got , nogot),"ConnectionRunnerThread");

            thread.start();
        }

        start.countDown();
        end.await();
        System.out.println("total invoke:"+(threadCount * count));
        System.out.println("got connection:"+got);
        System.out.println("not got connection"+nogot);
    }

    static  class ConnetionRunner implements Runnable{
        int count;
        AtomicInteger got;
        AtomicInteger notGot;

        public ConnetionRunner (int count, AtomicInteger got, AtomicInteger notGot){
            this.count = count;
            this.got = got;
            this.notGot = notGot;
        }

        @Override
        public void run(){
            try{
                start.await(); //
            }catch (Exception ex){}
            while(count >0 ){
                try{
                    Connection connection =  pool.fetchConnection(100);
                    if(connection!=null){
                        try {
                            connection.createStatement();
                            connection.commit();
                        }finally {
                            pool.releaseConnection(connection);
                            got.incrementAndGet();
                        }
                    }else {
                        notGot.incrementAndGet();
                    }
                }catch (Exception e){}
                finally {
                    count -- ;
                }
            }
            end.countDown();
        }
    }

}
