package com.liuyq.structure.sort;

/**
 * Created by liuyq on 2019/9/24.
 */
public class BiSearch {

    /**
     * sort[l ,r] =  sort[l,1+r/2]+sort[l+r/2+1, l]
     *
     * @param list
     * @param num
     * @return
     */
    public static Integer search(Integer[] list, Integer num, Integer start, Integer end) {
        if (end <= start) return -1;

        Integer center = (start + end) / 2;

        if (list[center] == num) {
            return center + 1;
        }
        if (list[center] > num) {
           return search(list, num, start, center);
        } else {
           return search(list, num, center, end);
        }
    }

    public static void main(String[] gars) {
        Integer[] a = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8};

        Integer s = search(a, 7, 0, 7);
        System.out.println(s);

    }


}
