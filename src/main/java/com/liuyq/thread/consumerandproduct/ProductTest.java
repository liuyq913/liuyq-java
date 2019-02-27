package com.liuyq.thread.consumerandproduct;

/**
 * Created by liuyq on 2019/2/27.
 */
public class ProductTest {
    public static void main(String[] agres){

        Clerk clerk = new Clerk();
        Thread thread1 =  new Thread(new Product(clerk));
        Thread thread2 = new Thread(new Consumer(clerk));
        thread1.start();
        thread2.start();
    }



    static class Product extends Thread {

        private Clerk clerk;

        Product(Clerk clerk){
            this.clerk = clerk;
        }
        @Override
        public void run() {
            while (true){
                try {
                    Thread.sleep(10);
                }catch (Exception e){}
                clerk.addProduct();
            }
        }
    }


    static class Consumer implements Runnable {

        private Clerk clerk;

        Consumer(Clerk clerk){
            this.clerk = clerk;
        }
        @Override
        public void run() {
            while (true){
                try {
                    Thread.sleep(1000);
                }catch (Exception e){}
                clerk.getProduct();
            }

        }
    }

    //产品类
    static  class Clerk{

        private static final Integer MAX_COUNT = 20;
        private static final Integer MIN_COUNT = 0;

        private volatile Integer countIng = 0;

        //生产产品
        public synchronized void addProduct(){
            if(countIng >= MAX_COUNT){
                try {
                    System.out.println("当前产品已经达到最大值，无法继续承载");
                    wait();
                } catch (InterruptedException e) {
                }
                return;
            }
            countIng++;
            System.out.println("第"+countIng+"生产完成！！！！！");
            notifyAll();
        }

        public synchronized  void getProduct(){
            if(countIng <= MIN_COUNT){
                try{
                    System.out.println("没有更多产品");
                    wait();
                } catch (InterruptedException e) {
                }
                return;
            }
            System.out.println("第"+countIng+"个产品被消费");
            countIng--;
            notifyAll();
        }

    }
}
