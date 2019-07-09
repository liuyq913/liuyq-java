package com.liuyq.structure.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by liuyq on 2019/7/9.
 * <p>
 * 快速排序
 * q为分区点
 * 递归公式：quick_sort[p..r] = quick_sort[p..q-1] + quick_sort[q+1.。r]
 * 终止条件: p> = r
 */
public class QuickSort {

    public void quick_sort(Integer[] a, int n) {
        quick_sort_c(a, 0, n - 1);
        System.out.println();
        System.out.println("最终结果：");
        Arrays.asList(a).stream().forEach(t -> System.out.print(t + ","));
    }

    private void quick_sort_c(Integer[] a, int p, int r) {
        if (p >= r) return;

        //获取分区点
        int q = partition(a, p, r);

        quick_sort_c(a, p, q - 1);
        quick_sort_c(a, q + 1, r);
    }

    private int partition(Integer[] a, int p, int r) {
        int i = p;
        int j = p;
        int pivot = r; //初始分区点位最后一位。

        for (int index = p; index < r; index++) {
            if (a[pivot] > a[j]) { //如果大于，则 a[i] 与a[j] 交换
                Integer temp = a[j];
                a[j] = a[i];
                a[i] = temp;
                i++;
            }
            j++;
        }
        //交换pivot 和  i的位置
        if (j == r) {
            int temp = a[pivot];
            a[pivot] = a[i];
            a[i] = temp;
        }
        return i;
    }


    @Test
    public void test(){
        Integer[] a = {44,3};
        quick_sort(a, 2);
    }


}
