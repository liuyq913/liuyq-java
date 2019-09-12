package com.liuyq.structure.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by liuyq on 2019/7/7.
 * 选择排序 选择排序是不稳定的（稳定相当于排序前后，相等的元素前后位置是否发生变化，变化就说明是不稳定的，不变化就是稳定的）
 *
 * 选择排序也分  已排序区间和未排序区间， 但是每次排序会从未排序区间中找到最小的元素放到已排序区间的末尾
 *
 */
public class SelectionSort {
    /**
     * 分已排序和未排序  将未排序最小的值存放到已排序的末尾
     *
     * @param list
     * @param n
     */
    public void SelectionSort(Integer[] list, int n) {
        if (n <= 1) return;

        for (int i = 0; i < n; i++) {
            int temp = list[i];
            int min = list[i]; //默认以未排序的第一个元素为最小
            int a = 0;
            //找到未排序的最小值
            for (int j = i; j < n; j++) {
                if (min > list[j]) {
                    min = list[j];
                    a = j;
                }
            }
            if(temp != min) { //最小值就是为未排序的第一个元素  不交换
                //最小值放在已排序的尾部
                list[i] = min;
                list[a] = temp;
            }

            //打印出来
            Arrays.asList(list).stream().forEach(t -> System.out.print(t));
            System.out.println();
        }
    }

    @Test
    public void test(){
        Integer[] list = {4,5,6,1,2,3};
        SelectionSort(list, 6);
    }
}
