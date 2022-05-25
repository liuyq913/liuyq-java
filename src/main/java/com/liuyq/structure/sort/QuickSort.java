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
 * </p>
 */
public class QuickSort {

    public void quick_sort(Integer[] a, int n, int k) {
       int kvalue =  quick_sort_c(a, 0, n - 1, k);
        System.out.println(kvalue);
        System.out.println("最终结果：");
        Arrays.asList(a).stream().forEach(t -> System.out.print(t + ","));
    }

    private int quick_sort_c(Integer[] a, int p, int r, int k) {
        if (p >= r) return -1;

        //获取分区点
        int q = partition(a, p, r);
        System.out.println("分区点为：" + q);

        int surplus = r - q + 1;

        if (surplus == k) {
            return a[q];
        } else if (surplus < k) {
            return quick_sort_c(a, q + 1, r, k - surplus);
        } else {
            return quick_sort_c(a, p, q - 1, k);
        }

    }

    private int partition(Integer[] a, int p, int r) {
        int i = p;
        int j = p;
        int pivot = r; //初始分区点位最后一位。

        for (int index = p; index < r; index++) {
            if (a[pivot] < a[j]) { //如果大于，则 a[i] 与a[j] 交换
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
    public void test() {
        Integer [] a = {2,3,2,1,1,6}; //完全有序的情况是：第一次的分区点是7  然后 2 3  4  5  6 再分区  分区点为6   每次都是  i 和 j位置上的数据交换
        quick_sort(a, 6,0);
    }

    @Test
    public  void test_topK(){
        Integer[] a = {6,6,6,8,9,9,9,12,12,12,14};
        quick_sort(a, 11, 4);
        System.out.println(a);
    }

}
