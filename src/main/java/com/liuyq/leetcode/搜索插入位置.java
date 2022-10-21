package com.liuyq.leetcode;

/**
 * @author liuyuqing
 * @className 搜索插入位置
 * @description https://leetcode.cn/problems/search-insert-position/
 * @date 2022/10/19 3:55 下午
 */
public class 搜索插入位置 {
    public static int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums[0] >= target) {
            return 0;
        }

        if (nums[nums.length - 1] < target) {
            return nums.length;
        }

        return erFenSearch(nums, 0, nums.length - 1, target);

    }


    private static Integer erFenSearch(int[] num, int left, int right, int target) {

        // 没找到
        if (right <= left || right - left == 1) {
            return left + 1;
        }


        int center = (right + left) / 2;
        if (target == num[center]) {
            return center;
        } else {
            // 在左边
            if (target < num[center]) {
                return erFenSearch(num, left, center, target);
                // 在右边
            } else {
                return erFenSearch(num, center, right, target);
            }
        }
    }

    public static void main(String[] agrs) {
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 7));
    }
}
