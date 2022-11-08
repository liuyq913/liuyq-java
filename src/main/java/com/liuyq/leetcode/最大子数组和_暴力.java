package com.liuyq.leetcode;

/**
 * @author liuyuqing
 * @className 最大子数组和
 * @description https://leetcode.cn/problems/maximum-subarray/
 * @date 2022/10/21 5:00 下午
 */
public class 最大子数组和_暴力 {

    public static int maxSubArray(int[] nums) {
       // return baoLi1(nums);
        return baoLi2(nums);
    }


    /**
     * 时间超长
     * @param nums
     * @return
     */
    private static int baoLi2(int[] nums) {

        int result = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            result = max(result, sum);
            for (int index = i + 1; index < nums.length; index++) {
                sum += nums[index];
                result = max(result, sum);
            }
        }
        return result;
    }

    private static Integer max(int result, int sum) {
        if (sum > result) {
            return sum;
        }
        return result;
    }


    /**
     * 时间超长
     * @param nums
     * @return
     */
    private static int baoLi1(int[] nums) {
        Integer sum = Integer.MIN_VALUE;
        for (Integer i : nums) {
            if (sum < i) {
                sum = i;
            }
        }

        return baoLi(nums, 0, sum);
    }


    private static int baoLi(int[] nums, int index, int sum) {

        if (index == nums.length) {
            return sum;
        }

        int current = nums[index];

        for (int i = index + 1; i <= nums.length - 1; i++) {
            // 跳到大于0 的位置
            if (index != 0 && sum < 0 && nums[i] >= 0) {
                return baoLi(nums, i, nums[i]);
            }
            current += nums[i];
            if (current > sum) {
                sum = current;
            }
        }
        return baoLi(nums, index + 1, sum);
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4
        }));
    }


}
