package com.liuyq.structure.sort;

/**
 * @author liuyuqing
 * @className QuickSort2
 * @description
 * @date 2022/4/16 5:58 下午
 */
public class QuickSort2 {

    public static int findRankKElement(int [] a, int k) {
        //第k大的数据，转换为数组下标需要减1
        int value = findRankKElement(a, 0, a.length - 1, k - 1);
        return value;
    }



    private static int partitionK(int[] a, int p, int r) {
        int pivot = a[r];
        int i = p;
        for(int j = p; j < r; ++j) {
            if (a[j] < pivot) {
                if (i == j) {
                    ++i;
                } else {
                    int tmp = a[i];
                    a[i++] = a[j];
                    a[j] = tmp;
                }
            }
        }

        int tmp = a[i];
        a[i] = a[r];
        a[r] = tmp;

        System.out.println("i=" + i);
        return i;
    }
    private static int findRankKElement(int[] a, int p, int r, int k) {
        int result;
        int pivot = partitionK(a, p, r);
        if(k == pivot) { //等于即返回
            result = a[pivot];
        }else if(k < pivot){//小于则在小区间查询
            result= findRankKElement(a, p, pivot - 1, k);
        }else {//大于则在大区间查询
            result = findRankKElement(a, pivot + 1, r, k);
        }
        return result;
    }


    public static void main(String[] agrs) {
        int[] a = {2,3,2,1,1,6};
        System.out.println(findRankKElement(a, 2));
        System.out.println(a);
    }
}
