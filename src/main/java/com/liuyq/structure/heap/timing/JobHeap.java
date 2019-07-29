package com.liuyq.structure.heap.timing;

import java.util.Arrays;

/**
 * Created by liuyq on 2019/7/26.
 */
public class JobHeap implements Runnable {

    private Job[] tasks;

    public JobHeap(Job[] tasks) {
        this.tasks = tasks;
    }


    /**
     * 移除最大元素  时间复杂度是O(logn)
     */
    public static Job removeMax(Job[] a, Integer n) {
        if (a == null) return null;
        //空堆
        if (n == 0) return null;

        //取到数组最后一个值
        Job last = a[n];
        //最后一个元素与堆顶元素交换
        a[n] = null;
        if (n != 1) { //只有一个元素直接删除就好
            a[1] = last;
        }

        //将栈顶元素找到合适的位置
        Integer farther = 1;
        Integer son = 2 * farther;
        while (son < n && son > 0 && a[son].getStartTime() > a[farther].getStartTime()) {
            Job temp = a[son];
            a[son] = a[farther];
            a[farther] = temp;
            //往下找
            farther = son;
            son = son * 2;
        }
        n--;
        println(a);
        return last;
    }


    public static void println(Job[] a) {
        System.out.println(Arrays.toString(a));
    }

    /**
     * 构建堆  自上往下堆化   时间复杂是O（n）  这种更好
     *
     * @param a 第一个节点是null
     * @param n n是数组中非空节点个数 也就堆中节点个数
     */
    public static void buildHeap(Job[] a, Integer n) {
        /**
         * 对与完全二叉树来说， 如果n是元素的个数，n/2+1 到  n的节点的是叶子节点，叶子节点无需堆化，因为叶子节点只能自己跟自己比较
         *
         * 那么 从1 -- n/2的节点均是非叶子节点
         */
        for (Integer i = n / 2; i >= 1; --i) {
            heapify(a, n, i);
        }
        System.out.println(Arrays.toString(a));
    }

    /**
     * 自上往下堆化
     *
     * @param a
     * @param n
     * @param i 需要找到特定位置的节点
     */
    public static void heapify(Job[] a, Integer n, Integer i) {
        while (true) {
            Integer maxPos = i;
            //找到i的左子节点， 比较 如果左子节点大于父节点  要还的位置是做左子节点
            if (i * 2 <= n && a[i].getStartTime() > a[i * 2].getStartTime()) maxPos = i * 2;
            //要还的位置是右子节点
            if (i * 2 + 1 <= n && a[maxPos].getStartTime() > a[i * 2 + 1].getStartTime()) maxPos = i * 2 + 1;
            if (maxPos == i) break;
            swap(a, i, maxPos);  //交换
            i = maxPos;
        }
    }

    public static void swap(Job[] a, Integer i, Integer maxPos) {
        Job temp = a[i];
        a[i] = a[maxPos];
        a[maxPos] = temp;
    }


    /**
     * 排序的时间复杂都是O（nlogn）
     * <p>
     * 排序  取堆顶元素和最后一个元素交换位置 然后最后一个位置之前的元素进行自上向下堆化
     * <p>
     * 比如： {null, 2, 3, 4, 5, 6, 7} 的数组
     * 转成堆之后：
     * [null, 7, 6, 4, 5, 3, 2]  大顶堆
     * 这个时候7 是堆顶元素，然后和数组最后一个元素进行交换 也就是下标为k的元素
     * -->[null, 2, 6, 4, 5, 3 ， 7] 然后 2 再进行向下堆化， 这个时候，堆化的元素是n-1 也就是最后一个元素不进行遍历
     * -->[null 6 ， 5， 4 ， 2 ， 3]  然后 k-- 也就是指到下标为3 的位置
     * 依次进行，知道k = 1 只剩栈顶元素
     * 整个数组就是有序的了
     */
    public static void sort(Job a[], Integer n) {
        buildHeap(a, n); //构建大顶堆  堆化之后，父级
        // 元素一定大于子元素，所有可以保证数组第一个元素一定是最大的
        Integer k = n;
        while (k > 1) {
            swap(a, 1, k);
            heapify(a, k - 1, 1);  //时间复杂都是O(logn)
            System.out.println(Arrays.toString(a));
            k--;
        }
    }

    @Override
    public void run() {
        while (tasks.length > 0) {
            buildHeap(tasks, tasks.length - 1);
            //去栈顶元素
            Job job = removeMax(tasks, tasks.length - 1);
            job.run();
            System.out.println("还剩任务个数"+tasks.length);
        }
    }

    public static void main(String[] agrs) {

        Job job1 = new Job(System.currentTimeMillis() + 3000, new Task(), 1);

        Job job2 = new Job(System.currentTimeMillis() + 4000, new Task(), 2);

        Job job3 = new Job(System.currentTimeMillis() + 5000, new Task(), 4);

        Job job4 = new Job(System.currentTimeMillis() + 6000, new Task(), 5);

        Job job5 = new Job(System.currentTimeMillis() + 7000, new Task(), 6);

        Job[] jobs = new Job[]{null, job1, job2, job3, job4, job5};
        JobHeap jobHeap = new JobHeap(jobs);
        jobHeap.run();
    }
}
