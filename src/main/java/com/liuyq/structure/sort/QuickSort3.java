package com.liuyq.structure.sort;

/**
 * @author liuyuqing
 * @className QuickSort2
 * @description
 * @date 2022/4/16 3:31 下午
 */
public class QuickSort3 {
    public static int findKth(int[] a, int n, int K) {
        // write code here
        return topK(a, 0, a.length - 1, K);
    }

    public static int topK(int[] arr, int left, int right, int k) {
        if (left > right) {
            return -1;
        }
        final int point = partition(arr, left, right);
        //后半部分还剩几个
        int surplus = right - point + 1;
        if (surplus == k) {
            return arr[point];
        } else if (surplus < k) {
            //在前半部分 因为大数在后面，所以要找 第 k-surplus 个最大
            return topK(arr, left, point - 1, k - surplus);
        } else {
            return topK(arr, point + 1, right, k);
        }

    }

    /**
     * 找point
     */
    public static int partition(int[] arr, int left, int right) {
        int first = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= first) {
                right--;
            }
            swap(arr, left, right);
            while (left < right && arr[left] <= first) {
                left++;
            }
            swap(arr, left, right);
        }
        return left;
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }



    public static void main(String[] agrs) {
        int[] a = {6,6,6,8,9,9,9,12,12,12,14};
        System.out.println(findKth(a, 11, 3));
        System.out.println(a);
    }
}
