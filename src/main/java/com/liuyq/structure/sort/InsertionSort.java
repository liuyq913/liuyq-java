package com.liuyq.structure.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by liuyq on 2019/7/7.
 * 插入排序
 *
 * 最坏时间复杂度是O(n^2)  最好时间复杂度是O(n)  平均时间复杂度是O(n^2)
 *
 */
public class InsertionSort {

    public static void insertSort(Integer[] list, int n) {
        if (n <= 1) return;

        for (int i = 1; i < n; i++) {
            Integer temp = list[i];
            Integer j = i - 1;
            for (; j >= 0; j--) {
                if (list[j] > temp) {
                    list[j + 1] = list[j];
                    list[j] = temp;
                } else {
                    break;
                }
            }
            Arrays.asList(list).stream().forEach(t -> System.out.print(t));
            System.out.println();
        }
    }


    @Test
    public void test2() {
        Integer[] vlaues = {4, 5, 6, 1, 3, 2};
        insertSort(vlaues, 6);
    }

    @Test
    public void test() {
        int j = 10;
        for (; j >= 0; j--) {
            System.out.println(j);
        }
    }
}
