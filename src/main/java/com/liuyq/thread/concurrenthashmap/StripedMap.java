package com.liuyq.thread.concurrenthashmap;

/**
 * Created by liuyq on 2018/10/29.
 * 基于散列的map中是用分段锁
 */
public class StripedMap {
    //同步策略: bucktes[n] 由 N_LOCKS[n % N_LOCKS]保护
    private static final int N_LOCKS = 16;

    private final Note[] bucktes;
    /**
     * 锁集合
     */
    private final Object[] lock;

    /**
     * 链表结构
     * @param
     */
    private static class Note<E,V>{
        E item;
        Note<E,V> next;
        Note<E,V> prev;
        V key;

        Note(Note<E,V> prev, E element, Note<E,V> next, V key) {
            this.item = element;
            this.next = next;
            this.prev = prev;
            this.key = key;
        }
    }

    /**
     * 初始化锁
     * @param numBucktes
     */
    public StripedMap(int numBucktes){
        bucktes = new Note[numBucktes];
        lock = new Object[N_LOCKS];
        for(int i = 0 ; i<N_LOCKS; i++){
            lock[i] = new Object();
        }
    }

    private final int hash(Object key){
        return Math.abs(key.hashCode() % bucktes.length);
    }

    /**
     * 一次get方法只需要获取一次锁
     * @param key
     * @return
     */
    public Object get(Object key){
        //hash一下。找到散列桶的位置
        Integer hash = this.hash(key);
        //由第hash% 16 个锁来保护
        synchronized (bucktes[hash % N_LOCKS]){
            //找到位置之后，在往下找，直至找到
            for(Note m = bucktes[hash]; null != m ; m = m.next){
               if(key.equals(m.key)){
                   return m.item;
               }
            }
        }
        return null;
    }


    /**
     * clear方法需要获取所以的锁
     */
    public void clear(){
        for(int i = 0; i<bucktes.length; i++){
            synchronized (lock[i % N_LOCKS]){
                bucktes[i] = null;
            }
        }
    }
}
