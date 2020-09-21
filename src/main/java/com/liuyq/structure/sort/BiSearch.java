package com.liuyq.structure.sort;

import org.junit.Test;
import org.omg.PortableInterceptor.INACTIVE;

/**
 * Created by liuyq on 2019/9/24.
 * 底层是数组
 * 时间复杂都是 O(logn) 查询范围 从开始的 n  n/2  n/4 n/8 ------n/2^k  k就是总共拆分了多少次，
 * 每一次拆分就是两个值的比较，所以时间复杂都是O(1) 所以 k= logn
 */
public class BiSearch {

    /**
     * sort[l ,r] =  sort[l,1+r/2]+sort[l+r/2+1, l]
     *
     * @param list
     * @param num
     * @return 返回值所处的位置
     */
    public static Integer search(Integer[] list, Integer num, Integer start, Integer end) {
        if (end <= start) return -1;

        Integer center = (start + end) / 2;

        if (list[center].equals(num)) {
            return center + 1;
        }
        if (list[center] > num) {
            return search(list, num, start, center - 1);
        } else {
            return search(list, num, center + 1, end);
        }
    }

    /**
     * 二分查找第一个相等的值
     *
     * @param list  已经排序的值
     * @param n     总共有多少个值
     * @param value 值
     * @return 返回值所处的位置
     */
    public static Integer searchOnce(Integer[] list, Integer n, Integer value) {
        Integer start = 0;
        Integer end = n - 1; // 最后一个

        while (start <= end) {
            Integer mid = start + ((end - start) >> 1); //中间

            if (value > list[mid]) {
                start = mid + 1;
            } else if (value < list[mid]) {
                end = mid - 1;
            } else { //相等的时候
                if (mid == 0) {
                    return mid + 1;
                }

                if (!list[mid].equals(list[mid - 1])) return mid + 1;
                end = mid - 1;
            }
        }
        return 0;
    }

    /**
     * 二分查找最后个相等的值
     *
     * @param list  要查找的列表
     * @param n     列表总长度
     * @param value 要查找的值
     * @return 返回值所处的位置
     */
    public static Integer searchLast(Integer[] list, Integer n, Integer value) {
        Integer start = 0;
        Integer end = n - 1; // 最后一个

        while (start <= end) {
            Integer mid = start + ((end - start) >> 1); //中间

            if (value > list[mid]) {
                start = mid + 1;
            } else if (value < list[mid]) {
                end = mid - 1;
            } else { //相等的时候
                if (mid == n - 1) {
                    return mid + 1;
                }

                if (!list[mid].equals(list[mid + 1])) return mid + 1;
                start = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 查询第一个大于或者等于给定值的元素
     *
     * @param list  要查找的列表
     * @param n     列表总长度
     * @param value 要查找的值
     * @return 返回值所处的位置
     */
    public static Integer searchOnceBigOrEq(Integer[] list, Integer n, Integer value) {
        Integer start = 0;
        Integer end = n - 1;

        while (start <= end) {
            Integer mid = start + ((end - start) >> 1);

            if (value > list[mid]) {
                start = mid + 1;
            } else { //value <= list[mid]
                if (mid == 0 || list[mid - 1] < value) { // list[mid- 1]< value  <= list[mid]
                    return mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }

    /**
     * 查询最后小于或者等于给定值的元素
     *
     * @param list
     * @param n
     * @param value
     * @return
     */
    public static Integer searchLastLassOrEq(Integer[] list, Integer n, Integer value) {
        Integer start = 0;
        Integer end = n - 1;
        while (start < end) {
            Integer mid = start + ((end - start) >> 1);

            if (value < list[mid]) {
                start = mid + 1;
            } else { //value 大于等于 中间值
                if (mid == n-1) { // 已经是最后一个值
                    return mid + 1;
                }
                if (list[mid + 1] > value) { //中间值的前一个元素大于给定值
                    return mid + 1;
                }

                end = mid - 1;
            }
        }

        return -1;
    }

    @Test
    public void search() {
        Integer[] a = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8};
        Integer s = search(a, 100, 0, 7);
        System.out.println(s);
    }

    @Test
    public void searchOnce() {
        Integer[] list = new Integer[]{1, 1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(searchOnce(list, 9, 1));
    }

    @Test
    public void searchLast() {
        Integer[] list = new Integer[]{1, 1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(searchLast(list, 9, 1));
    }

    @Test
    public void searchOnceBigOrEq() {
        Integer[] list = new Integer[]{1, 1, 2, 3, 4, 5, 6, 7, 7, 8};
        System.out.println(searchOnceBigOrEq(list, 10, 7));
    }

}
