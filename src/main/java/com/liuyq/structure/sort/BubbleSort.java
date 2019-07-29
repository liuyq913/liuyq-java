package com.liuyq.structure.sort;

import java.util.Arrays;

/**
 * Created by liuyq on 2018/4/2。
 * 冒泡排序 ：最坏时间复杂度是 O（n^2）  最好时间复杂都是 O(n)
 *          平均复杂都是 O(n^2)
 *          平均复杂度是是的算法
 *          这里引入排序度的概念， 满顺度是 n*(n-1) /2   满虚度 = 逆序度 + 有序度
 *          逆序度表示还要进行排序的次数  最坏的时候逆序度= 满虚度    最好的时候 =1
 *          那么取平均值，平均就是 n *（n-1）/ 4  去掉低阶和常量也就是O(n^2)
 *
 *
 */
public class BubbleSort {
    //简单版本
    public static void bubbleSort(Integer[] agrs) {
        for (int i = 0; i < agrs.length; i++) {
            for (int j = 0; j < agrs.length - i - 1; j++) {
                if (agrs[i] > agrs[j]) {
                    int temp = agrs[i];
                    agrs[i] = agrs[j];
                    agrs[j] = temp;
                }
            }
        }
    }


    /**
     * 优化版  有序之后无需再进行排序操作
     *
     * @param a
     * @param n 数组大小
     */
    // 冒泡排序，a 表示数组，n 表示数组大小
    public static void bubbleSort(Integer[] a, int n) {
        if (n <= 1) return;

        for (int i = 0; i < n; ++i) {
            Arrays.stream(a).forEach(t -> System.out.print(t));
            System.out.println();
            // 提前退出冒泡循环的标志位
            boolean flag = false;
            for (int j = 0; j < n - i - 1; ++j) {
                if (a[j] > a[j + 1]) { // 交换
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    flag = true;  // 表示有数据交换
                }
            }
            if (!flag) break;  // 没有数据交换，提前退出
        }
    }

    public static void main(String[] agrs) {
        //Integer[] a = {3,5,4,1,2,6};
        //bubbleSort(a, a.length);

        String s= null;
        Arrays.asList(s.split(",")).contains(2);
    }


}
