package com.liuyq.thread.thread67;

/**
 * Created by liuyq on 2018/2/28.
 */
public interface SetObserver<E> {

    /**
     * 添加元素后回调
     * @param set
     * @param element
     */
    void added(ObservableSet<E> set, E element);
}
