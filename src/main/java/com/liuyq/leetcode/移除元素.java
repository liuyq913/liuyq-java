package com.liuyq.leetcode;

import java.util.Arrays;

/**
 * @author liuyuqing
 * @className 移除元素
 * @description https://leetcode.cn/problems/remove-element/
 * @date 2022/10/10 5:41 下午
 */
public class 移除元素 {

    public static int removeElement(Integer[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int head = 0;
        int end = nums.length - 1;

        for (; ; ) {

            if (end <= head) {
                break;
            }
            // 找到对头第一个等于val的元素
            if (nums[head] != val) {
                head++;
                continue;
            }
            // 交换位置
            if (nums[end] != val) {
                nums[head] = nums[end];
                nums[end] = val;
                head++;
                end--;
                // 找到队尾不等于val的元素 end的位置
            } else {
                end--;
                if (end == 0) {
                    nums = new Integer[]{};
                    return 0;
                }
            }
        }
        return nums[end] != val ? end + 1 : end;
    }


    public static void main(String[] args) {

        Integer[] param3 = new Integer[]{3, 2, 2, 3};
        System.out.println("长度:" + removeElement(param3, 3));
        System.out.println(Arrays.asList(param3));

    }
}
