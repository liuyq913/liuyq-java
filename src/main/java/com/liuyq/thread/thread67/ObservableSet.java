package com.liuyq.thread.thread67;

import com.google.common.collect.ForwardingSet;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by liuyq on 2018/2/28.
 *
 * 过度同步，会导致性能降低，死锁等
 *
 * 所以在一个被同步的区域内部，不要调用设计成要被覆盖的方法，或者是由客户端以函数对象的形式提供的方法
 * 因为无法控制他，这属于外来方法
 */
public class ObservableSet<E> extends ForwardingSet<E> {

    public ObservableSet(){super(new HashSet<E>());}

    protected ObservableSet(Set<E> delegate) {
        super(delegate);
    }

    private final List<SetObserver<E>> observers = new ArrayList<SetObserver<E>>();

    public void addObserver(SetObserver<E> observer){
        synchronized (observers){
            observers.add(observer);
        }
    }

    public boolean removeObserver(SetObserver<E> observer){
        synchronized (observers){
          return observers.remove(observer);
        }
    }

    private void notifyElementAdded(E element){
        synchronized (observers){
            for(SetObserver<E> observer : observers){ //这个时候正处于遍历列表的过程
                observer.added(this, element);
            }
        }
    }

    /**
     * 将外来的方法的调用移除同步代码块,就可以避免异常和死锁
     * @param element
     */
    private void notifyElementAddedNew(E element){
        List<SetObserver<E>> snapshot = null;
        synchronized (observers){
            snapshot = new ArrayList<SetObserver<E>>(observers); //创建一个副本
        }
        for(SetObserver<E> observer : snapshot){
            observer.added(this, element);
        }
    }

    @Override
    public boolean add(E element) {
        boolean added = super.add(element);
        if(added) notifyElementAdded(element);
        return added;
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        boolean result = false;
        for(E element : collection){
            result |= add(element);
        }
        return result;
    }

        @Test
        public void test1(){
        ObservableSet<Integer> set = new ObservableSet<>(new HashSet<Integer>());

        set.addObserver(new SetObserver<Integer>() {
            @Override
            public void added(ObservableSet<Integer> set, Integer element) {
                System.out.println(element);
                if(element == 23) set.removeObserver(this); //add方法遍历观察者列表的同时，又删除列表中的观察者，这是非法的
            }
        });
        for(int i = 0 ;i < 100; i++){
            set.add(i);
        }
    }

    /**
     * 这个方法会遇到死锁
     *
     * 因为线程池的get（）方法会等runable的线程执行完之后才会执行主线程的代码
     *set.add(i); //主线程已经拿到了observers的锁
     * s.removeObserver方法试图获取锁，就获取不到，所以一直就死锁了
     *
     */
    @Test
    public void test2(){
        ObservableSet<Integer> set = new ObservableSet<>(new HashSet<Integer>());

        set.addObserver(new SetObserver<Integer>() {
            @Override
            public void added(ObservableSet<Integer> set, Integer element) {
                System.out.println(element);
                if(element == 23){
                    ExecutorService executorService = Executors.newSingleThreadExecutor();
                    final SetObserver<Integer> observer = this;
                    try {
                        executorService.submit(new Runnable() {
                            @Override
                            public void run() {
                                set.removeObserver(observer); //尝试获取锁，就获取不到，死锁了
                            }
                        }).get();
                    }catch (ExecutionException ex){
                        throw new AssertionError(ex.getCause());
                    }catch (InterruptedException ex){
                        throw new AssertionError(ex.getCause());
                    }finally {
                        executorService.shutdown();
                    }
                }
            }
        });
        for(int i = 0 ;i < 100; i++){
            set.add(i); //主线程已经拿到了observers的锁
        }
    }
}
