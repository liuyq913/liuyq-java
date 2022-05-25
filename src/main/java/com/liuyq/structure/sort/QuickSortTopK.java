package com.liuyq.structure.sort;

/**
 * @author liuyuqing
 * @className QuickSort2
 * @description
 * @date 2022/4/16 3:31 下午
 */
public class QuickSortTopK {

    public static int quick_sort_c(int[] a, int low, int high, int k) {

        //获取分区点
        int q = partition(a, low, high);
        // System.out.println("分区点为：" + q);
        if (k == q - low + 1) {
            return a[q];
        } else if (q - low + 1 > k) {
            return quick_sort_c(a, low, q - 1, k);
        } else {
            return quick_sort_c(a, q + 1, high, k - (q - low + 1));
        }
    }

    public static int quick_sort_c2(int[] a, int low, int high, int k) {

        //获取分区点
        int q = partition_2(a, low, high);
        //  System.out.println("分区点为：" + q);

        if (k == q - low + 1) {
            return a[q];
        } else if (q - low + 1 > k) {
            return quick_sort_c2(a, low, q - 1, k);
        } else {
            return quick_sort_c2(a, q + 1, high, k - (q - low + 1));
        }
    }


    public static int partition(int a[], int low, int high) {
        int temp = a[low];

        while (low < high) {
            // 小于标杆在右
            while (low < high && a[high] <= temp)
                high--;


            if (low == high)
                break;
            else
                a[low] = a[high];

            // 大于标杆在左
            while (low < high && a[low] >= temp)
                low++;

            if (low == high)
                break;
            else
                a[high] = a[low];
        }

        a[low] = temp;
        return low;
    }


    public static int partition_2(int[] a, int p, int r) {
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

    public static void main(String[] agrs) {
        int a[] = {9, 9, 12, 5, 10, 6};
        int a2[] = {9, 9, 12, 5, 10, 6};
        System.out.println(quick_sort_c(a, 0, 5, 4));


        System.out.println(quick_sort_c2(a2, 0, 5, 4));


    }
}
