package com.liuyq.jdk.util;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by liuyq on 2019/7/30.
 * <p>
 * <p>
 * jdk 8 相当于 jdk 7 的改进
 * 改进一：
 * 取消segments字段，直接采用transient volatile HashEntry<K,V>[]
 * table保存数据，采用table数组元素作为锁，从而实现了对每一行数据进行加锁，进一步减少并发冲突的概率
 * 改进二：
 * 将原先table数组＋单向链表的数据结构，变更为table数组＋单向链表＋红黑树的结构。对于hash表来说，
 * 最核心的能力在于将key hash之后能均匀的分布在数组中。如果hash之后散列的很均匀，那么table数组中的每个队列长度主要为0或者1。
 * 但实际情况并非总是如此理想，虽然ConcurrentHashMap类默认的加载因子为0.75，但是在数据量过大或者运气不佳的情况下，
 * 还是会存在一些队列长度过长的情况，如果还是采用单向列表方式，那么查询某个节点的时间复杂度为O(n)；因此，对于个数超过8(默认值)的列表，
 * jdk1.8中采用了红黑树的结构，那么查询的时间复杂度可以降低到O(logN)，可以改进性能。
 */
public class ConcurrentHashMapTest {
    public static void main(String[] gars) {
        ConcurrentHashMap<Integer, Integer> concurrentHashMap = new ConcurrentHashMap();

        for (int i = 0; i < 17; i++) {
            concurrentHashMap.put(i, i);
        }

       // System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
