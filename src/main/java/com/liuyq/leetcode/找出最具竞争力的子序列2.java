package com.liuyq.leetcode;

import java.util.Stack;

/**
 * @author liuyuqing
 * @className 找出最具竞争力的子序列2
 * @description
 * @date 2022/6/28 11:31 上午
 */
public class 找出最具竞争力的子序列2 {
    public static int[] mostCompetitive(int[] nums, int k) {

        Stack<Integer> stack = new Stack<>();
        stack.add(-1);
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            //当前元素比队尾元素小，将队尾元素出栈
            //此处需要另外判断数组剩余长度够不够填满栈，不然最后答案长度可能会小于k
            while (nums[i] < stack.peek() && k - stack.size() + 1 < len - i) {
                stack.pop();
            }
            if (stack.size() < k + 1) {
                stack.add(nums[i]);
            }
        }

        int[] ret = new int[k];

        while (k > 0) {
            ret[--k] = stack.pop();
        }

        return ret;
    }


    public static void main(String[] args) {
        mostCompetitive(new int[]{71, 18, 52, 29, 55, 73, 24, 42, 66, 8, 80, 2}, 3);
    }

}
