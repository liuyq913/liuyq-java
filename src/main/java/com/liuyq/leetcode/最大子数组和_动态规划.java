package com.liuyq.leetcode;

/**
 * @author liuyuqing
 * @className 最大子数组和_动态规划
 * @description https://leetcode.cn/problems/maximum-subarray/
 * @date 2022/11/8 2:27 下午
 */
public class 最大子数组和_动态规划 {


    public static int maxSubArray(int[] nums) {

        int length = nums.length;
        int[] states = new int[length];

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            int myself = nums[i];
            // 先把自己放进去
            states[i] = myself;
            if (i > 0) {
                // 尝试把自己+前面的值相加大的话进就放
                int heBing = states[i] + states[i - 1];
                if (heBing > states[i]) {
                    states[i] = heBing;
                }
            }
            if (max < states[i]) {
                max = states[i];
            }
        }


        return max;
    }


    public static void main(String[] args) {
        int[] item = new int[]{1};
        System.out.println(maxSubArray(item));

    }
}
