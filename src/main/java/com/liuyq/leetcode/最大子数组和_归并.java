package com.liuyq.leetcode;

/**
 * @author liuyuqing
 * @className 最大子数组和_归并
 * @description
 * @date 2022/10/24 1:25 下午
 */
public class 最大子数组和_归并 {

    public static int maxSubArray(int[] nums) {
        return guiBing(nums, 0, nums.length - 1);
    }


    public static int guiBing(int[] nums, int start, int end) {

        if (start >= end) {
            return nums[end];
        }

        // 取中值
        int center = (end - start) / 2 + start;

        // 左边最大值
        int left = guiBing(nums, center + 1, end);
        // 右边最大值
        int right = guiBing(nums, start, center);
        // 中间最大值
        int centerMax = centerMax(nums, start, end);

        int max = max(left, right, centerMax);

        return max;
    }


    private static int centerMax(int[] nums, int start, int end) {
        int center = (end - start) / 2 + start;

        // 左边连续的最大值
        int leftMax = nums[center];
        int lefSum = nums[center];
        for (int i = center - 1; i >= start; i--) {
            lefSum += nums[i];
            if (leftMax < lefSum) {
                leftMax = lefSum;
            }
        }

        // 右边最大值
        int rightMax = nums[center + 1];
        int rightSum = nums[center + 1];
        for (int i = center + 2; i <= end; i++) {
            rightSum += nums[i];
            if (rightMax < rightSum) {
                rightMax = rightSum;
            }
        }

        return leftMax + rightMax;
    }


    private static int max(int start, int end, int center) {
        if (start >= end && start >= center) {
            return start;
        }

        if (end >= start && end >= center) {
            return end;
        }

        if (center >= start && center >= end) {
            return center;
        }
        return start;
    }


    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
