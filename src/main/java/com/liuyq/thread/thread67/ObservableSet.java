package com.liuyq.thread.thread67;

import com.google.common.collect.ForwardingSet;

import java.util.*;

/**
 * Created by liuyq on 2018/2/28.
 *
 * 过度同步，会导致性能降低，死锁等
 *
 * 所以在一个被同步的区域内部，不要调用设计成要被覆盖的方法，或者是由客户端以函数对象的形式提供的方法
 * 因为无法控制他，这属于外来方法
 */
public class ObservableSet<E> extends ForwardingSet<E> {


    public ObservableSet(Set<E> delegate) {
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
            for(SetObserver<E> observer : observers){
                observer.added(this, element);
            }
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

    public static void main(String[] agrs){
        ObservableSet<Integer> set = new ObservableSet<>(new HashSet<Integer>());

        set.addObserver(new SetObserver<Integer>() {
            @Override
            public void added(ObservableSet<Integer> set, Integer element) {
                System.out.println(element);
                if(element == 23) set.removeObserver(this);
            }
        });
        for(int i = 0 ;i < 100; i++){
            set.add(i);
        }
    }
}
