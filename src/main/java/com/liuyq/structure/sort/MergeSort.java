package com.liuyq.structure.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by liuyq on 2019/7/7.
 * 归并排序
 * <p>
 * 递推公式：
 * merge_sort(p…r) = merge(merge_sort(p…q), merge_sort(q+1…r))
 * <p>
 * 终止条件：
 * p >= r 不用再继续分解
 *
 *  时间复杂度 O（nlogn）  最好最坏平均d都是O（nlogn）
 *  空间复杂都O(n)
 */
public class MergeSort {
    public void mergeSort(Integer[] list, int n) {
        //将数组按中间拆开，然后各个部分排序，然后再合并
        mergeSort_c(list, 0, n - 1);
        System.out.println();
        System.out.println("最终结果：");
        Arrays.asList(list).stream().forEach(t -> System.out.print(t + ","));
    }

    /**
     * 递归调用函数
     *
     * @param list
     * @param i
     * @param i1
     */
    private void mergeSort_c(Integer[] list, int i, int i1) {
        //终止条件
        if (i >= i1) return;

        //拆分  去中间位置
        Integer p = (i + i1) / 2;
        System.out.println();
        System.out.println("初始list的为：");
        Arrays.asList(Arrays.copyOfRange(list, i, i1 + 1)).stream().forEach(t -> System.out.print(t + ","));
        System.out.println("从" + list[p] + "开始拆分");
        mergeSort_c(list, i, p);
        mergeSort_c(list, p + 1, i1);

        //合并 i -- p  p+1 -- i1 成一个完整的数组
        merge(list, i, p, i1);
    }

    private void merge(Integer[] list, int i, Integer p, int i1) {
        int a = i;
        int j = p + 1;
        int k = 0;
        //初始化一个temp 和list大小一样
        Integer[] temp = new Integer[i1 - i + 1];
        //取拆分的数组的第一个元素进行比较，把小的放在temp数组里面
        // （这里如果这个数组中有相同的元素，那么将左边的优先放在temp里面，也就是说归并排序是稳定的）
        while (a <= p && j <= i1) {
            if (list[a] <= list[j]) {
                temp[k++] = list[a++];
            } else {
                temp[k++] = list[j++];
            }
        }

        //哪个数组还剩余值
        int start = 0;
        int end = 0;
        if (a <= p) {
            start = a;
            end = p;
        } else {
            start = j;
            end = i1;
        }
        //将剩余的放在temp里面
        for (; start <= end; start++) {
            temp[k++] = list[start];
        }

        //把temp拷贝到list[i...i1]里面;
        for (int w = 0; w <= i1 - i; w++) {
            list[i+w] = temp[w];
        }
        System.out.print("排序合并后：");
        Arrays.asList(list).stream().forEach(e -> System.out.print(e + ","));
        System.out.println();
    }


    @Test
    public void test() {
        Integer[] a = {44, 34, 55, 88, 9,111};
        mergeSort(a, 6);
    }

    @Test
    public void test2() {
        for (int i = 0; i <= 1; i++) {
            System.out.println(i);
        }
    }
}
